package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteAllServlet", value = "/deleteAllServlet")
public class deleteAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uids = request.getParameterValues("uid");
        UserService service=new UserServiceImpl();
        service.deleteAll(uids);
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet?currentPage=1");



    }
}
