<%--
  Created by IntelliJ IDEA.
  User: CZQ
  Date: 2021/11/3
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
    <script>
        var reg = /^\w{3,8}$/;
        var rreg_email=/^\w+@+\.\w$/
        $(function () {
            $("#user").blur(function () {

                const username = $(this).val();
                var flag = reg.test(username);
                if (flag){
                    $("#user").css("border","");
                    $.get("registerServlet",{user:username},function (data) {
                        if (data.userExist){
                            $("#msg").css("color","red");
                            $("#user").css("border","1px solid red");
                            $("#msg").html(data.msg);
                        }else {
                            $("#msg").css("color","green");
                            $("#user").css("border","");
                            $("#msg").html(data.msg);
                        }
                    },"json")
                }else {
                    $("#msg").css("color","red");
                    $("#user").css("border","1px solid red");
                    $("#msg").html("请输入3-8位用户名");
                }
                //发送ajax请求，服务端返回数据{"userExist":true,"msg":"用户已存在"}{"userExist":false,"msg":"可以使用"}


            })
        })
    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">用户注册</h3>
    <form action="${pageContext.request.contextPath}/registerServlet" method="post">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="user" class="form-control" id="user"  placeholder="请输入3~8位用户名"/>
            <span id="msg"></span>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password"  placeholder="请输入密码"/>
            <span>请输入6~14位密码</span>
        </div>

        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" value="" style="width: 120px;"/>
            <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/></a>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="注册" id="post">
        </div>
    </form>

    <!-- 出错显示的信息框 -->

</div>
</body>
</html>

<script>
    window.onload=function () {
        var code = document.getElementById("vcode");
        code.onclick=function () {
            var time=new Date().getTime()
            code.src="/checkCodeServlet?"+time;

        }


    }




</script>