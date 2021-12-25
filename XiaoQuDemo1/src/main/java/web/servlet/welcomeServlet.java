package web.servlet;

import service.RecordService;
import service.TFDaoService;
import service.impl.RecordServiceImpl;
import service.impl.TFDaoServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "welcomeServlet", value = "/welcomeServlet")
public class welcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TFDaoService service=new TFDaoServiceImpl();
        RecordService service1=new RecordServiceImpl();
        String user = request.getParameter("user");
        int count1 = service1.findRecordCountByName(user);
        int count = service.findTFCountByName(user);
        request.setAttribute("count",count);
        request.setAttribute("RecordCount",count1);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/CarServlet?action=user&user="+user).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
