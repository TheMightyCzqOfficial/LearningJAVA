package web.servlet;


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
import java.util.Map;

@WebServlet("/loginTestDemo")
public class loginTestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.removeAttribute("msg");
        request.setCharacterEncoding("utf-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
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
        UserService service=new UserServiceImpl();
        System.out.println(login+","+request.getAttribute("check_code"));
        Login checklogin=service.login(login);
        //request.setAttribute("check_code",check_code);
        if (check.equalsIgnoreCase(check_code)){
            if(checklogin==null){
                request.setAttribute("msg","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else{
                if (login.getUser().equals("admin")){
                    session.setAttribute("username",login.getUser());//通过“user”共享数据 两次请求使用session
                    response.sendRedirect(request.getContextPath()+"/main.jsp");
                }else {
                    //session.setAttribute("username",login.getUser());//通过“user”共享数据 两次请求使用session
                    response.sendRedirect(request.getContextPath()+"/findUserServlet?user="+login.getUser());//验证是否激活
                }

            }

        }
        else {
            request.setAttribute("msg","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }
}
