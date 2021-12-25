<%--
  Created by IntelliJ IDEA.
  User: CZQ
  Date: 2021/11/4
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- HTML5文档-->
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
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="sex" value="男" checked="checked"/>男
            <input type="radio" name="sex" value="女"/>女
        </div>

        <div class="form-group">
            <label for="mobil">手机号：</label>
            <input type="text" class="form-control" id="mobil" name="mobil" placeholder="请输入手机号">
        </div>

        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱">
        </div>
        <div class="form-group" hidden>
            <label >类型：</label>
            <input type="text" name="type" value="0" readonly>
        </div>
        <div class="form-group">
            <label for="house">住所：</label>
            <input type="text" class="form-control" id="house" name="house" placeholder="请输入住所">
        </div>
        <div class="form-group">
            <label >用户账号：</label>
            <select class="form-control" name="username">
                <c:forEach items="${loginUser}" var="u">
                    <c:if test="${u!='admin'}">
                        <option value ="${u}">${u}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>


        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <a class="btn btn-default"  href="${pageContext.request.contextPath}/add.jsp">重置</a>
            <a class="btn btn-default"  href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=1">返回</a>
        </div>
    </form>
</div>
</body>
</html>