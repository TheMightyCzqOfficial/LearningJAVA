<%--
  Created by IntelliJ IDEA.
  User: CZQ
  Date: 2021/11/9
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>小区管理系统-业主端</title>

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
    <script>
        $(window).ready(function () {
            $("#check").click(function () {
                var pwd = $("#password").val();
                if (pwd!==""){
                    $("#form").submit();
                }else if (pwd===""){
                   alert("密码不能为空！")
                }
            })
        })
        $('#myModal').on('shown.bs.modal', function () {
            $('#myInput').focus()
        })
    </script>
    <!-- 修改密码界面 -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">修改密码</h4>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/updatePasswordServlet" method="post" id="form">
                            <label>请输入修改后的密码：</label>
                            <input type="text" name="username" value="${username}" readonly hidden>
                            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <!-- 指定type 表单内button属性默认为submit -->
                    <button class="btn btn-primary" type="button" id="check" >提交</button>
                </div>
                    </form>

            </div>
            </div>
        </div>
    </div>

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid" >
        <!-- Brand and toggle get grouped for better mobile display -->
        <script>
            setInterval( " document.getElementById('datetime').innerHTML=new Date().toLocaleString();",1000);
        </script>
        <div class="page-header">
            <h1>小区管理系统-业主端 <small id="datetime"></small>
            </h1>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav nav-tabs">
                <li role="presentation" style="float: right"><p class="navbar-text">业主 ${username},欢迎您</p></li>
                <li role="presentation" class="dropdown" style="float: right">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                        个人信息修改 <span class="glyphicon glyphicon-menu-down"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#" data-toggle="modal" data-target="#myModal">修改密码</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#" onclick="if (confirm('是否退出？')) location.href='login.jsp'">退出登录</a></li>
                    </ul>
                </li>
                <li role="presentation"><a href="#" onclick="document.getElementById('frame').src='/welcomeServlet?user=${username}'">首页</a></li>
                <li role="presentation"><a href="#" onclick="document.getElementById('frame').src='/findTfByNameServlet?user=${username}'">报修/投诉</a></li>
                <li role="presentation"><a href="#" onclick="document.getElementById('frame').src='/findAllRecordServlet?user=${username}'">缴费信息</a></li>


            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

    <iframe  id="frame" src="${pageContext.request.contextPath}/welcomeServlet?user=${username}" height="100%" width="100%" frameborder="0" scrolling="no">


</iframe>
</body>
</html>
