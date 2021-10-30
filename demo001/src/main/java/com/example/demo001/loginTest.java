package com.example.demo001;

import Dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "loginTest", value = "/loginTest")
public class loginTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        user.setUsername(username);
//        user.setPassword(password);
        UserDao ud=new UserDao();
        User loginuser = ud.login(user);
        System.out.println(loginuser);
        if(loginuser==null){
            request.getRequestDispatcher("/failServlet").forward(request,response);//登陆失败
        }
        else {
            request.setAttribute("user",user);//通过“user”共享数据
            request.getRequestDispatcher("/successServlet").forward(request,response);//登陆成功
        }

    }
}
