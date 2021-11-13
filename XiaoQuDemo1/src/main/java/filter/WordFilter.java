package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/TestServlet")
public class WordFilter implements Filter {

    private List<String> list=new ArrayList<String>();
    public void init(FilterConfig config) throws ServletException {
        System.out.println("初次加载成功");
        ServletContext servletContext = config.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/word.txt");
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(realPath), StandardCharsets.UTF_8));
            String line=null;
            while((line=br.readLine())!=null){
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //固定写法
        System.out.println("文字过滤已启动");
       ServletRequest proxy_req= (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")){
                    String value = (String) method.invoke(request, args);
                    if (value!=null){
                        for (String str:list){
                            if (value.contains(str)){
                                value= value.replaceAll(str, "***");//replace方法执行后会生成新的字符串，因此需要重新赋值
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(request, args);
            }
        });
        chain.doFilter(proxy_req, response);
    }
}
