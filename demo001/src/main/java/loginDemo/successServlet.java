package loginDemo;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "successDemo1", value = "/successDemo1")
public class successServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("123");
        User user = (User) request.getAttribute("user");
        System.out.println(user);
        String username = user.getUsername();
        System.out.println(username);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("登录成功"+username+"欢迎您");
    }
}
