package com.example.demo001;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo1")
public class requestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();//获取请求方式
        String contextPath = request.getContextPath();//获取虚拟目录
        String requestURI = request.getRequestURI();//获取请求URI /requestDemo1
        StringBuffer requestURL = request.getRequestURL();//获取请求URL http://localhost:8080/requestDemo1
        String servletPath = request.getServletPath();//获取servle路径
        String queryString = request.getQueryString();//获取请求参数
        String remoteAddr = request.getRemoteAddr();//获取客户机ip地址
        String protocol = request.getProtocol();//获取协议版本

        System.out.println(method);
        System.out.println(contextPath);
        System.out.println(requestURI);
        System.out.println(requestURL);
        System.out.println(servletPath);
        System.out.println(queryString);
        System.out.println(remoteAddr);
        System.out.println(protocol);
        System.out.println("-------------------");


        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for(String name:keySet){
            System.out.println(name+":");
            String[] strings = parameterMap.get(name);
            for(String value:strings){
                System.out.println(value);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }
}
