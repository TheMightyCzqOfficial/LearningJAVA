package web.servlet;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "findUserServlet", value = "/findUserServlet")
public class findUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String user = request.getParameter("user");
        if (id!=null){
            int uid=Integer.parseInt(id);
            UserService service=new UserServiceImpl();
            User userById = service.findUserById(uid);
            request.setAttribute("user",userById);
            request.getRequestDispatcher("/update.jsp").forward(request,response);
        }
        System.out.println("用户名："+user);
        UserService service=new UserServiceImpl();
        String activateUser = service.findActivateUser(user);
        System.out.println(activateUser+"123");
        if (activateUser==null){
            response.sendRedirect("/activate.jsp");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("username",user);
            response.sendRedirect("/userMain.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
