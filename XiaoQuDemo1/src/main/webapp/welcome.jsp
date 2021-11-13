<%--
  Created by IntelliJ IDEA.
  User: CZQ
  Date: 2021/11/10
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎使用业主端！</h1><br>
<h1>业主：${user}</h1><br>
<c:if test="${count==0}">
    <h1>您没有未处理投诉与报修信息</h1>
</c:if>
<c:if test="${count!=0}">
    <h1>您当前共有${count}条未处理投诉与报修信息，请关注！</h1>
</c:if>

<c:if test="${RecordCount==0}">
    <h1>您的费用已缴清，感谢您的配合，祝您生活愉快！</h1>
</c:if>
<c:if test="${RecordCount!=0}">
    <h1>您当前共有${RecordCount}笔费用未缴清，请及时缴费，谢谢！</h1>
</c:if>

</body>
</html>
