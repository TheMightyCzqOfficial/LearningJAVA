package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter");
        HttpServletRequest req = (HttpServletRequest) request;
        req.setCharacterEncoding("utf-8");
        Object username = req.getSession().getAttribute("username");
        Object user = req.getSession().getAttribute("user");
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/main.jsp")||requestURI.contains("/userMain.jsp")){
            if (username!=null||user!=null){
                chain.doFilter(request, response);
            }
            else {
                req.setAttribute("Login_msg","您尚未登陆，请登录！");
                req.getRequestDispatcher("/login.jsp").forward(req,response);
            }
        }
        else {
            chain.doFilter(request, response);
        }

    }
}
