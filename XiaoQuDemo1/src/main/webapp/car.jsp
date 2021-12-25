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
  <script >
    function deleteUser(id){
      if (confirm("您确定要删除吗?")){
        alert("删除成功!");
        location.href="${pageContext.request.contextPath}/CarServlet?action=delete&id="+id;
      }

    }
    function addTime(id,username,number){
      if (confirm("您确定要延长用户："+username+" 名下，车牌号为："+number+" 的车一年吗?")){
        alert("操作成功!");
        location.href="${pageContext.request.contextPath}/CarServlet?action=addTime&id="+id;
      }
    }
  </script>
</head>
<body>

<div class="container" style="height: 100%;width: 100%">


  <h3 style="text-align: center">车辆信息列表</h3>


  <div style="float: right;margin: 5px">

    <a class="btn btn-primary" href="${pageContext.request.contextPath}/CarServlet?action=preAdd">添加车辆</a>

  </div>

  <form action="" id="selectUser" method="post">

    <table border="1" class="table table-bordered table-hover">
      <tr class="success">
        <th>编号</th>
        <th>归属用户</th>
        <th>车辆类型</th>
        <th>车牌号</th>
        <th>到期时间</th>
        <th>车位编号</th>
        <th>操作</th>
      </tr>

      <c:forEach items="${car}" var="c" varStatus="s">
        <tr>
          <td>${s.count}</td>
          <td>${c.username}</td>
          <td>${c.type}</td>
          <td>${c.car_number}</td>
          <td>${c.end_time}</td>
          <td>${c.id}</td>
          <td><a class="btn btn-default btn-sm" href="javascript:deleteUser(${c.id})">删除</a>
            <a class="btn btn-default btn-sm" href="javascript:addTime('${c.id}','${c.username}','${c.car_number}')">续费延期一年</a></td>
        </tr>
      </c:forEach>

    </table>
  </form>


</div>
</body>
</html>
