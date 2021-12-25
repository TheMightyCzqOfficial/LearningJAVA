package web.servlet.car;

import domain.Car;
import service.CarDaoService;
import service.impl.CarDaoServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addCarServlet", value = "/addCarServlet")
public class addCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarDaoService service=new CarDaoServiceImpl();
        Car car=new Car();
        String username = request.getParameter("username");
        String type = request.getParameter("type");
        String car_number = request.getParameter("car_number");
        String end_time = request.getParameter("end_time");
        car.setUsername(username);
        car.setType(type);
        car.setCar_number(car_number);
        car.setEnd_time(end_time);
        service.addCar(car);
        response.sendRedirect("/CarServlet");
    }
}
