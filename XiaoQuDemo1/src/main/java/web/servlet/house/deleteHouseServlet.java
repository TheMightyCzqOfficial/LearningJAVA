package web.servlet.house;

import service.HouseService;
import service.impl.HouseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteHouseServlet", value = "/deleteHouseServlet")
public class deleteHouseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HouseService houseService=new HouseServiceImpl();
        houseService.deleteHouse(id);
        response.sendRedirect(request.getContextPath()+"/HouseListServlet");
    }
}
