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

<div class="container"style="height: 100%;width: 100%">


    <h3 style="text-align: center">缴费信息表</h3>
    <c:if test="${type=='admin'}">
    <div style="float: right;margin: 5px">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/addRecordServlet?user=">添加缴费</a>

    </div>
    </c:if>
    <table border="1" class="table table-bordered table-hover">

        <c:if test="${type!='admin'}">
            <tr class="success">
                <th>编号</th>
                <th>费用详情</th>
                <th>缴费金额</th>
                <th>费用产生时间</th>
                <th>状态</th>
            </tr>
        <c:forEach items="${record}" var="r" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${r.text}</td>
                <td>${r.money}</td>
                <td>${r.create_time}</td>
                <c:if test="${r.status==0}">
                    <td style="color: red">未缴费</td>
                </c:if>
                <c:if test="${r.status!=0}">
                    <td style="color: greenyellow">已缴费</td>
                </c:if>
            </tr>
        </c:forEach>
        </c:if>
        <c:if test="${type=='admin'}">
            <tr class="success">
                <th>编号</th>
                <th>业主</th>
                <th>费用详情</th>
                <th>缴费金额</th>
                <th>费用产生时间</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
        <c:forEach items="${record}" var="r" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${r.name}</td>
                <td>${r.text}</td>
                <td>${r.money}</td>
                <td>${r.create_time}</td>
                <c:if test="${r.status==0}">
                    <td style="color: red">未缴费</td>
                </c:if>
                <c:if test="${r.status!=0}">
                    <td style="color: greenyellow">已缴费</td>
                </c:if>
                <c:if test="${r.status==1}">
                    <td style="color: greenyellow">已缴费</td>
                </c:if>
                <c:if test="${r.status==0}">
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/updateRecordServlet?rid=${r.rid}">确认已缴费</a></td>
                </c:if>
            </tr>
        </c:forEach>
        </c:if>

    </table>

</div>
</body>
</html>
