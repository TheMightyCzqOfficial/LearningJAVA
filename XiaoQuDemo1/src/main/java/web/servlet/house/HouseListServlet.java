package web.servlet.house;


import domain.House;
import service.HouseService;
import service.impl.HouseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HouseListServlet", value = "/HouseListServlet")
public class HouseListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HouseService service=new HouseServiceImpl();
        List<House> houses = service.findAll();
        //转发到页面
        request.setAttribute("houses",houses);
        request.getRequestDispatcher("/houseList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
