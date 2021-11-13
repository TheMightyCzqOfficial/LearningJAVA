package web.servlet.TsFix;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.TFDaoService;
import service.UserService;
import service.impl.TFDaoServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "updateTFServlet", value = "/updateTFServlet")
public class updateTFServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        TFDaoService service=new TFDaoServiceImpl();
        String type = request.getParameter("type");
        if (type.equals("ts")){
            int id = Integer.parseInt(request.getParameter("id"));
            service.updateTs(id);
            response.sendRedirect(request.getContextPath()+"/TsListServlet");
        }else if (type.equals("fix")){
            int id = Integer.parseInt(request.getParameter("id"));
            service.updateFix(id);
            response.sendRedirect(request.getContextPath()+"/TsListServlet");
        }


    }
}
