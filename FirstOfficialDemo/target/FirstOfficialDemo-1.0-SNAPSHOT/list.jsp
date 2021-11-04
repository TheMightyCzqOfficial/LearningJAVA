<%--
  Created by IntelliJ IDEA.
  User: CZQ
  Date: 2021/11/2
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
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
    <script>
        function deleteUser(id,name){
            if (confirm("您确定要删除"+name+"吗？"))
                location.href="${pageContext.request.contextPath}/deleteServlet?id="+id;
        }
        function deleteUserByCheckbox(){
            var id=document.getElementById("checked");
            if (confirm("您确定要删除"+id.name+"吗？"))
                location.href="${pageContext.request.contextPath}/deleteServlet?id="+id.value;
        }
        var all=document.getElementById("selectAll");
        all.onclick=function () {
            var cbox = document.getElementById("checked");
            cbox.checked=true;

        }

    </script>
</head>
<body>
<div class="container">
    <div>${username},欢迎您
        <a class="btn btn-primary" href="login.jsp">退出登录</a>
    </div>

    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;margin: 5px">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">名字</label>
                <input type="text" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">年龄</label>
                <input type="email" class="form-control" id="exampleInputEmail2" >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right;margin: 5px">

        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:deleteUserByCheckbox()">删除选中</a>
    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="selectAll"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
       <c:forEach items="${users}" var="user" varStatus="s">
        <tr>
            <td><input type="checkbox" id="checked" name="${user.name}" value="${user.id}"></td>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="javascript:deleteUser('${user.id}','${user.name}')">删除</a></td>
        </tr>
       </c:forEach>

    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
