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
    <title></title>

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

</head>
<body>

<div class="container" style="height: 100%;width: 100%">


    <h3 style="text-align: center">业主 ${user} 的报修/投诉信息表</h3>


    <div style="float: right;margin: 5px">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/findNameServlet?user=${user}">添加新投诉/报修</a>

    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>类型</th>
            <th>发起人</th>
            <th>标题</th>
            <th>内容</th>
            <th>状态</th>
        </tr>

        <c:forEach items="${ts}" var="ts" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>投诉</td>
                <td>${ts.ts_user}</td>
                <td>${ts.ts_name}</td>
                <td>${ts.ts_text}</td>
                <c:if test="${ts.status==0}">
                    <td style="color: red">未处理</td>
                </c:if>
                <c:if test="${ts.status!=0}">
                    <td style="color: greenyellow">已处理</td>
                </c:if>

            </tr>
        </c:forEach>
        <c:forEach items="${fix}" var="fix" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>报修</td>
                <td>${fix.fix_user}</td>
                <td>${fix.fix_name}</td>
                <td>${fix.fix_text}</td>
                <c:if test="${fix.status==0}">
                    <td style="color: red">未处理</td>
                </c:if>
                <c:if test="${fix.status!=0}">
                    <td style="color: greenyellow">已处理</td>
                </c:if>
            </tr>
        </c:forEach>

    </table>

</div>
</body>
</html>
