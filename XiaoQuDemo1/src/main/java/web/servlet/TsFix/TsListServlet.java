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

@WebServlet(name = "TsListServlet", value = "/TsListServlet")
public class TsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TFDaoService service=new TFDaoServiceImpl();
        List<Ts> ts = service.findAllTs();
        List<Fix> fix = service.findAllFix();
        //转发到页面
        request.setAttribute("ts",ts);
        request.setAttribute("fix",fix);
        request.getRequestDispatcher("/TFlist.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
