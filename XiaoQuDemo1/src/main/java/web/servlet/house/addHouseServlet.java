package web.servlet.house;

import domain.House;
import org.apache.commons.beanutils.BeanUtils;
import service.HouseService;
import service.impl.HouseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "addHouseServlet", value = "/addHouseServlet")
public class addHouseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        House house=new House();
        try {
            BeanUtils.populate(house,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HouseService houseService=new HouseServiceImpl();
        houseService.addHouse(house);

        response.sendRedirect(request.getContextPath()+"/HouseListServlet");

    }
}
