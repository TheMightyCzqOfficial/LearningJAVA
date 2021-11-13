package web.servlet.record;

import domain.Record;
import org.apache.commons.beanutils.BeanUtils;
import service.RecordService;
import service.impl.RecordServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "addRecordServlet", value = "/addRecordServlet")
public class addRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecordService service=new RecordServiceImpl();
        List map = service.findUserNameAndId();
        request.setAttribute("map",map);
        request.getRequestDispatcher("/addRecord.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Record record=new Record();
        try {
            BeanUtils.populate(record,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        RecordService service=new RecordServiceImpl();
        service.addRecord(record);
        response.sendRedirect(request.getContextPath()+"/findAllRecordServlet");

    }
}
