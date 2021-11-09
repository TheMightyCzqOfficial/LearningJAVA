package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "findUserByPageServlet", value = "/findUserByPageServlet")
public class findUserByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb=new StringBuilder();
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> condition = request.getParameterMap();
        System.out.println(condition.keySet());
        if (condition.keySet().contains("address")){
            Set<String> keySet = condition.keySet();
            for (String key:keySet){
                if (key.equals("currentPage")){
                    continue;
                }
                sb.append(key).append("=").append(condition.get(key)[0]).append("&");
            }

        }
        //System.out.println(sb.toString());
        request.getSession().setAttribute("url",sb.toString());
        UserService service=new UserServiceImpl();
        //int totalCount = service.findTotalCount();
        String currentPage =request.getParameter("currentPage");
        System.out.println(currentPage);
        if (currentPage==null){
            currentPage="1";
        }
        //int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int row = 10;//限制每页5条记录
        //condition= (Map<String, String[]>) request.getSession().getAttribute("condition");
        PageBean<User> pageBean = service.findUserByPage(Integer.parseInt(currentPage), row,condition);
        System.out.println(pageBean);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
        //System.out.println(totalCount);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
