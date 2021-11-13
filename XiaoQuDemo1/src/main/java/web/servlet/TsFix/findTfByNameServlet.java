package web.servlet.TsFix;

import domain.Fix;
import domain.Ts;
import service.TFDaoService;
import service.impl.TFDaoServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "findTfByNameServlet", value = "/findTfByNameServlet")
public class findTfByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        TFDaoService service=new TFDaoServiceImpl();
        List<Fix> fix = service.findFixByName(user);
        List<Ts> ts = service.findTsByName(user);
        request.setAttribute("user",user);
        request.setAttribute("ts",ts);
        request.setAttribute("fix",fix);
        request.getRequestDispatcher("/TfListForUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
