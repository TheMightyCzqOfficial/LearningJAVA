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
            var myDate=new Date().toLocaleDateString()
            var replace = myDate.replace(/\//g,'');
            $('#end').attr("value",replace)
            $('#update').click(function () {
                $('#motaitext').html("正在查询中。。。。。");
                $('#OK').html("");
                var t = $('#addForm').serializeArray();
                $.ajax({
                    url: "/getData",
                    data: t,
                    type: "POST",
                    // dataType: "json",
                    success: function(data) {
                        // data = jQuery.parseJSON(data);  //dataType指明了返回数据为json类型，故不需要再反序列化
                        $('#motaitext').html(data)
                        $('#OK').html('<button type="button" class="btn btn-default"  id="btn1" onclick="location.reload()">确认</button>')
                    }
                });

            })


        })

    </script>
</head>
<body>

<div class="container" style="height: 100%;width: 100%">

    <div style="text-align: center">
        <h3>股票详情：</h3><br>
    <h3>${info.name},${info.code},${info.area},${info.type}</h3>


        <form id="addForm" method="get" action="${pageContext.request.contextPath}/getData">
            <input type="text" name="code" value="${info.code}" hidden>
            <label>开始时间</label>
            <input type="text" name="start" placeholder="参照右边格式输入起始日期">
            <label>截止时间</label>
            <input type="text"id="end" name="end"  >
        </form>
        <button  class="btn btn-default" id="update" data-toggle="modal" data-target="#myModal"   >更新数据</button>
        <a class="btn btn-default" href="${pageContext.request.contextPath}/stockList" role="button">返回</a>
    </div>

    <form action="" id="selectUser" method="post">

        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>编号</th>
                <th>交易日期</th>
                <th>开盘价</th>
                <th>当日最高</th>
                <th>当日最低</th>
                <th>收盘价</th>
                <th>昨收价</th>
                <th>涨跌额</th>
                <th>涨跌幅</th>
                <th>成交量（手）</th>
                <th>成交额（千元）</th>


            </tr>

            <c:forEach items="${data}" var="c" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${c.trade_date}</td>
                    <td>${c.open}</td>
                    <td>${c.high}</td>
                    <td>${c.low}</td>
                    <td>${c.close}</td>
                    <td>${c.pre_close}</td>
                    <td>${c.change_amount}</td>
                    <td>${c.pct_chg}%</td>
                    <td>${c.vol}</td>
                    <td>${c.amount}</td>


                </tr>
            </c:forEach>

        </table>
    </form>
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
