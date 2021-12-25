package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Login;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service=new UserServiceImpl();
        String username = request.getParameter("user");
        List<Login> register = service.findRegister(username);
        Map<String,Object> map=new HashMap<String,Object>();

        response.setContentType("text/html;charset=utf-8");
        if ((register.toString()).equals("[]")){//用户不存在
            map.put("userExist",false);
            map.put("msg","用户名可用");
        }
        else {
            map.put("userExist",true);
            map.put("msg","您的用户名已存在！");
        }
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),map);
        //response.sendRedirect("/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service=new UserServiceImpl();
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("user");
        List<Login> register = service.findRegister(username);
        System.out.println(register.toString()+123);
        if (register.toString().equals("[]")){
            String password = request.getParameter("password");
            Map<String, String[]> parameterMap = request.getParameterMap();
            String[] checks = parameterMap.get("verifycode");
            String check = checks[0];//获取验证码数据
            HttpSession session = request.getSession();
            String check_code = (String) session.getAttribute("check_code");
            Login login=new Login();
            try {
                BeanUtils.populate(login,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
//        user.setUsername(username);
//        user.setPassword(password);

            System.out.println(login+","+request.getAttribute("check_code"));

            //request.setAttribute("check_code",check_code);
            if (check.equalsIgnoreCase(check_code)){
                if((login.getUser()==null)||(login.getPassword()==null)){

                    request.setAttribute("msg","用户名或密码为空，请重新输入");
                    request.getRequestDispatcher("/register.jsp").forward(request,response);
                }
                else if (login.getPassword().length()>14||login.getUser().length()>8){
                    request.setAttribute("msg","用户名或密码格式有误，请重新输入");
                    request.getRequestDispatcher("/register.jsp").forward(request,response);
                }else{
                    service.register(login);
                    session.setAttribute("username",login.getUser());//通过“user”共享数据 两次请求使用session
                    response.sendRedirect(request.getContextPath()+"/success.jsp");
                }

            }
            else {

                request.setAttribute("msg","验证码错误");
                request.getRequestDispatcher("/register.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("msg","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
//


    }

}
