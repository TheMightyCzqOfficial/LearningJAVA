package Study.cookiesDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CookiesDemo3", value = "/CookiesDemo3")
public class CookiesDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag=false;
        if (cookies!=null&&cookies.length>0){
            for (Cookie co:cookies){
                String name = co.getName();
                if (name.equals("lastTime")){
                    String value = co.getValue();
                    flag=true;
                    Date date=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println(str_date);
                    str_date=URLEncoder.encode(str_date,"utf-8");//cookies采用URL编码
                    System.out.println(str_date);
                    co.setValue(str_date);//设置当前时间为cookies
                    response.addCookie(co);
                    value=URLDecoder.decode(value,"utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次的访问时间为："+value+"</h1>");
                    break;
                }
            }
        }
        if(cookies==null||cookies.length==0||flag==false){
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println(str_date);
            str_date=URLEncoder.encode(str_date,"utf-8");//cookies采用URL编码
            System.out.println(str_date);
            Cookie c=new Cookie("lastTime",str_date);
            c.setMaxAge(60*60*24*30);//设置存活时间为一个月
            response.addCookie(c);
            str_date=URLDecoder.decode(str_date,"utf-8");
            response.getWriter().write("<h1>欢迎您首次访问，您的访问时间为："+ str_date +"</h1>");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
