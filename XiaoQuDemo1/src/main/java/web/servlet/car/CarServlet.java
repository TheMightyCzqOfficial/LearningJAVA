package web.servlet.car;

import domain.Car;
import service.CarDaoService;
import service.UserService;
import service.impl.CarDaoServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CarServlet", value = "/CarServlet")
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        CarDaoService service=new CarDaoServiceImpl();
        UserService userService=new UserServiceImpl();
        if (null==action){
            List<Car> carList = service.findAll();
            request.setAttribute("car",carList);
            request.getRequestDispatcher("/car.jsp").forward(request,response);
        }else if (action.equals("preAdd")){
            List<String> username = userService.findUsername();
            request.setAttribute("username",username);
            request.getRequestDispatcher("/addCar.jsp").forward(request,response);
        }else if (action.equals("delete")){
            String id = request.getParameter("id");
            service.deleteCar(Integer.parseInt(id));
            response.sendRedirect("/CarServlet");
        }else if (action.equals("addTime")){
            String id = request.getParameter("id");
            service.updateCar(Integer.parseInt(id));
            response.sendRedirect("/CarServlet");
        }else if (action.equals("user")){
            String username = request.getParameter("user");
            List<Car> car = service.findByUsername(username);
            request.setAttribute("car",car);
            request.getRequestDispatcher("/welcome.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
