package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updatePasswordServlet", value = "/updatePasswordServlet")
public class updatePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);
        UserService service=new UserServiceImpl();
        service.updatePwd(username,password);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script>alert(\"修改成功请重新登录\");location.href=\"/login.jsp\";</script>");
        //response.sendRedirect("/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
