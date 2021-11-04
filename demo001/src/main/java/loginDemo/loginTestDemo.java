package loginDemo;

import Dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

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
        request.setCharacterEncoding("utf-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        Map<String, String[]> parameterMap = request.getParameterMap();
        String[] checks = parameterMap.get("check");
        String check = checks[0];//获取验证码数据
        HttpSession session = request.getSession();
        String check_code = (String) session.getAttribute("check_code");
        User user=new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        user.setUsername(username);
//        user.setPassword(password);
        UserDao ud=new UserDao();
        User loginuser = ud.login(user);
        System.out.println(loginuser);
        if (check.equalsIgnoreCase(check_code)){
            if(loginuser==null){
                request.setAttribute("user_error","用户名或密码有误，请重新输入!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else{
                session.setAttribute("username",user.getUsername());//通过“user”共享数据 两次请求使用session
                response.sendRedirect("/success.jsp");
            }

        }
        else {
            request.setAttribute("cc_error","验证码有误，请重新输入!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }
}
