package Study.cookiesDemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "getCookiesDemo1", value = "/getCookiesDemo1")
public class getCookiesDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie c:cookies){
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name+":"+value);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
