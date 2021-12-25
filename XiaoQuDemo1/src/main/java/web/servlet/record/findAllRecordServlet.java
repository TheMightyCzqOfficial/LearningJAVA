package web.servlet.record;

import dao.impl.RecordDaoImpl;
import domain.Record;
import service.RecordService;
import service.impl.RecordServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "findAllRecordServlet", value = "/findAllRecordServlet")
public class findAllRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("utf-8");
        String user = request.getParameter("user");
        System.out.println(user);
        RecordService service=new RecordServiceImpl();
        if (user==null){
            List<Record> records = service.findAll();
            request.setAttribute("type","admin");
            request.setAttribute("record",records);
        }else {
            System.out.println("1111111111");
            RecordDaoImpl dao=new RecordDaoImpl();
            int id = dao.findIdByName(user);
            List<Record> records = service.findById(id);
            request.setAttribute("type",user);
            request.setAttribute("record",records);
        }
        request.getRequestDispatcher(request.getContextPath()+"/recordList.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
