package web.servlet.TsFix;

import domain.Fix;
import domain.House;
import domain.Ts;
import org.apache.commons.beanutils.BeanUtils;
import service.HouseService;
import service.TFDaoService;
import service.impl.HouseServiceImpl;
import service.impl.TFDaoServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "addTFServlet", value = "/addTFServlet")
public class addTFServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        TFDaoService service=new TFDaoServiceImpl();
        String type = request.getParameter("type");
        if (type.equals("ts")){
            String user = request.getParameter("user");
            String name = request.getParameter("name");
            String text = request.getParameter("text");
            int status = Integer.parseInt(request.getParameter("status"));
            Ts ts=new Ts();
            ts.setTs_user(user);
            ts.setTs_name(name);
            ts.setTs_text(text);
            ts.setStatus(status);
            service.addTs(ts);
            response.sendRedirect(request.getContextPath()+"/findTfByNameServlet?user="+user);
        }else if (type.equals("fix")){
            String user = request.getParameter("user");
            String name = request.getParameter("name");
            String text = request.getParameter("text");
            int status = Integer.parseInt(request.getParameter("status"));
            Fix fix=new Fix();
            fix.setFix_user(user);
            fix.setFix_name(name);
            fix.setFix_text(text);
            fix.setStatus(status);
            service.addFix(fix);
            response.sendRedirect(request.getContextPath()+"/findTfByNameServlet?user="+user);


        }


    }
}
