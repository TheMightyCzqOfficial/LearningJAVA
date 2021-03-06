<%--
  Created by IntelliJ IDEA.
  User: CZQ
  Date: 2021/11/3
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>用户登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
    <c:if test="${Login_msg!=null}">
        <script>
            alert("${Login_msg}");
            location.href="/login.jsp";
        </script>
    </c:if>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">用户登录</h3>
    <form action="${pageContext.request.contextPath}/loginTestDemo" method="post">
        <div class="form-group">
            <label for="user">用户名：</label>
            <c:if test="${param.get('username')!=null}">
                <input type="text" name="user" class="form-control" id="user" value="${param.get('username')}" placeholder="请输入用户名"/>
            </c:if>
            <c:if test="${param.get('username')==null}">
                <input type="text" name="user" class="form-control" id="user" value="admin" placeholder="请输入用户名"/>
            </c:if>

        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" value="" style="width: 120px;"/>
            <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/></a>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录" id="post">
            <a class="btn btn btn-primary" href="register.jsp" >注册</a>
        </div>
    </form>


</div>
</body>
</html>
    <c:if test="${msg!=null}">
    <script>
        alert("${msg}");
    </script>
    </c:if>
<script>
    window.onload=function () {
        var code = document.getElementById("vcode");
        code.onclick=function () {
            var time=new Date().getTime()
            code.src="/checkCodeServlet?"+time;

        }

    }





</script>

