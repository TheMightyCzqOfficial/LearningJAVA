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


    $(document).ready(function () {

      $('#search').click(function () {
        // $('#motaitext').html("正在查询中。。。。。");
        // $('#OK').html("");
        var t = $('#addForm').serializeArray();
        $.ajax({
          url: "/search",
          data: t,
          type: "POST",
          // dataType: "json",
          success: function(data) {
            // data = jQuery.parseJSON(data);  //dataType指明了返回数据为json类型，故不需要再反序列化
            $('#motaitext').html(data)
            $('#OK').html('<button type="button" class="btn btn-default"  id="btn1" onclick="location.reload()">确认</button>')
            //
          }
        });
      })
    })



  </script>
</head>
<body>

<div class="container" style="height: 100%;width: 100%">


  <h3 style="text-align: center">股 票 池</h3>


  <div style="text-align: center;margin: 5px">

    <form id="addForm" method="get" action="${pageContext.request.contextPath}/search">
      <label>搜索股票</label>
      <input type="text" name="name" placeholder="请输入股票名称或代码" >
      <button  class="btn btn-default"  id="search" >搜索</button>
    </form>
  </div>


  <form action="" id="selectUser" method="post">

    <table border="1" class="table table-bordered table-hover">
      <tr class="success">
        <th>编号</th>
        <th>股票代码</th>
        <th>股票名称</th>
        <th>股票地区</th>
        <th>股票类型</th>
        <th>详情</th>

      </tr>

      <c:forEach items="${pageInfo.list}" var="c" varStatus="s">
        <tr>
          <td>${s.count}</td>
          <td>${c.code}</td>
          <td>${c.name}</td>
          <td>${c.area}</td>
          <td>${c.type}</td>
          <td><a class="btn btn-default" href="${pageContext.request.contextPath}/stockData?code=${c.code}" role="button">查看详情</a>

          </td>
        </tr>
      </c:forEach>

    </table>
  </form>
  <nav aria-label="Page navigation">
    <ul class="pagination  pagination-lg">
      <li>
        <a href="${pageContext.request.contextPath}/stockList?page=1&size=${pageInfo.pageSize}" aria-label="Previous">
          <span aria-hidden="true">首页</span>
        </a>
        <a href="${pageContext.request.contextPath}/stockList?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}" >
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>

        <c:if test="${pageInfo.pageNum<=5}">
          <c:forEach begin="1" end="10" var="num">
            <c:if test="${pageInfo.pageNum==num}">
              <li class="active"><a href="${pageContext.request.contextPath}/stockList?page=${num}&size=${pageInfo.pageSize}">${num}</a></li>
            </c:if>
            <c:if test="${pageInfo.pageNum!=num}">
              <li ><a href="${pageContext.request.contextPath}/stockList?page=${num}&size=${pageInfo.pageSize}">${num}</a></li>
            </c:if>
          </c:forEach>
        </c:if>


      <c:if test="${pageInfo.pageNum>5 && pageInfo.pageNum<pageInfo.pages-4}">
        <c:forEach begin="${pageInfo.pageNum-5}" end="${pageInfo.pageNum+4}" var="num">
          <c:if test="${pageInfo.pageNum==num}">
            <li class="active"><a href="${pageContext.request.contextPath}/stockList?page=${num}&size=${pageInfo.pageSize}">${num}</a></li>
          </c:if>
          <c:if test="${pageInfo.pageNum!=num}">
            <li ><a href="${pageContext.request.contextPath}/stockList?page=${num}&size=${pageInfo.pageSize}">${num}</a></li>
          </c:if>
        </c:forEach>
      </c:if>

      <c:if test="${pageInfo.pageNum>=pageInfo.pages-4 && pageInfo.pages>5}">
      <c:forEach begin="${pageInfo.pageNum-5}" end="${pageInfo.pages}" var="num">
        <c:if test="${pageInfo.pageNum==num}">
          <li class="active"><a href="${pageContext.request.contextPath}/stockList?page=${num}&size=${pageInfo.pageSize}">${num}</a></li>
        </c:if>
        <c:if test="${pageInfo.pageNum!=num}">
          <li ><a href="${pageContext.request.contextPath}/stockList?page=${num}&size=${pageInfo.pageSize}">${num}</a></li>
        </c:if>
      </c:forEach>
      </c:if>



      <li>
        <a href="${pageContext.request.contextPath}/stockList?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
        <a href="${pageContext.request.contextPath}/stockList?page=${pageInfo.pages}&size=${pageInfo.pageSize}" >
          <span aria-hidden="true">末页</span>
        </a>
      </li>
    </ul>
  </nav>
  <!-- Modal -->
  <div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
        </div>
        <div class="modal-body" id="motaitext">
          正在查询中，请稍后。。。。。
        </div>
        <div class="modal-footer" id="OK">

        </div>
      </div>
    </div>
  </div>

</div>
</body>
</html>
