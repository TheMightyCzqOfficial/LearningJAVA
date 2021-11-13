<%--
  Created by IntelliJ IDEA.
  User: CZQ
  Date: 2021/11/9
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <title>小区管理系统-管理员</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid" >
        <!-- Brand and toggle get grouped for better mobile display -->
        <script>
            setInterval( " document.getElementById('datetime').innerHTML=new Date().toLocaleString();",1000);
        </script>
        <div class="navbar-header" style="float: right">
            <p class="navbar-text" id="datetime"></p>
            <p class="navbar-text" >管理员 ${username},欢迎您</p>
            <button type="button" class="btn btn-default navbar-btn" onclick="if (confirm('是否退出？')) location.href='login.jsp'">退出登录</button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="#" onclick="document.getElementById('frame').src='/findUserByPageServlet'">业主信息</a></li>
                <li role="presentation"><a href="#" onclick="document.getElementById('frame').src='/HouseListServlet'">楼房信息</a></li>
                <li role="presentation"><a href="#" onclick="document.getElementById('frame').src='/TsListServlet'">报修/投诉</a></li>
                <li role="presentation"><a href="#" onclick="document.getElementById('frame').src='/findAllRecordServlet'">缴费信息</a></li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<iframe  id="frame" src="${pageContext.request.contextPath}/findUserByPageServlet" height="100%" width="100%" frameborder="0" scrolling="no"></iframe>
</body>
</html>
