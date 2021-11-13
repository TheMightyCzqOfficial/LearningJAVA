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
    <center><h3>添加新投诉/报修</h3></center>
    <form action="${pageContext.request.contextPath}/addTFServlet" method="post">
        <div class="form-group">
            <label >选择添加内容:</label>
            <select class="form-control" name="type">
                <option value ="ts">投诉</option>
                <option value ="fix">报修</option>
            </select>
        </div>
        <div class="form-group">
            <label >投诉人:</label>
            <input type="text" class="form-control"  name="user" value="${user}" readonly >
        </div>
        <div class="form-group">
            <label >标题:</label>
            <input type="text" class="form-control"  name="name" placeholder="请输入标题">
        </div>
        <div class="form-group">
            <label >内容:</label>
            <input type="text" class="form-control"  name="text" placeholder="请输入内容">
        </div>
        <div class="form-group" hidden>

            <input type="text" class="form-control"  name="status" value="0" placeholder="未处理" >
        </div>


        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <a class="btn btn-default"  href="${pageContext.request.contextPath}/addTF.jsp">重置</a>
            <a class="btn btn-default"  href="${pageContext.request.contextPath}/findTfByNameServlet?user=${user}">返回</a>
        </div>
    </form>
</div>
</body>
</html>