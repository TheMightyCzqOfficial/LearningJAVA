package web.servlet.record;

import service.RecordService;
import service.impl.RecordServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updateRecordServlet", value = "/updateRecordServlet")
public class updateRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("rid"));
        RecordService service=new RecordServiceImpl();
        service.updateRecord(id);
        response.sendRedirect(request.getContextPath()+"/findAllRecordServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
