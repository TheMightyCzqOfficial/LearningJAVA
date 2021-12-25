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
    <script >
        function deleteUser(id,name){
            if (confirm("您确定要删除"+name+"吗?")){
                alert("删除成功!");
                location.href="/deleteServlet?id="+id;
            }

        }

        function selectAll(){
            var elementsByName = document.getElementsByName("uid");
            var flag=false;
            for(var i=0;i<elementsByName.length;i++) {
                if (elementsByName[i].checked){
                    flag=true;
                }else {
                    flag=false;
                    break;
                }

            }
            if (flag===true){//已选中
                for(var i=0;i<elementsByName.length;i++) {
                    elementsByName[i].checked=false
                }
            }else {
                for(var i=0;i<elementsByName.length;i++) {
                    elementsByName[i].checked=true
                }
            }

        }
        function isSelect(){
            var elementsByName = document.getElementsByName("uid");
            for(var i=0;i<elementsByName.length;i++) {
                if (elementsByName[i].checked){
                    elementsByName[i].checked=false;
                }else if(!elementsByName[i].checked) {
                    elementsByName[i].checked=true;
                }

            }
        }
        function deleteAll(){
            var name = document.getElementsByName("uid");
            var itemStr="";
            var flag=false;
            for(var i=0;i<name.length;i++) {
                if(name[i].checked){
                    flag=true;
                    itemStr+=name[i].id+" ";
                }
            }
            if (flag===false){
                alert("未选中，请检查!");
            }else {

                if (confirm("您确定要删除"+itemStr+"吗")){
                    document.getElementById("selectUser").submit();
                    alert("删除成功!");
                    //location.href = "/userListServlet";

                }
            }


        }
    </script>
</head>
<body>

<div class="container">


    <h3 style="text-align: center">业主信息列表</h3>
    <div style="float: left;margin: 5px">
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="get">
            <div class="form-group">
                <label >名字</label>
                <input type="text" class="form-control" name="name" >
            </div>
            <div class="form-group">
                <label >性别</label>
                <input type="radio" name="sex" value="男" checked="checked"/>男
                <input type="radio" name="sex" value="女"/>女
            </div>
            <div class="form-group">
                <label >住所</label>
                <input type="text" class="form-control"  name="house">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
            <c:if test="${param.keySet().contains(\"name\")}">
                <a  class="btn btn-default" href="${pageContext.request.contextPath}/findUserByPageServlet">退出查询</a>
            </c:if>
        </form>
    </div>

    <div style="float: right;margin: 5px">

        <a class="btn btn-primary" href="add.jsp">添加业主</a>
        <a class="btn btn-primary" href="javascript:void(0);" onclick="deleteAll()">删除选中</a>
    </div>
    <form action="${pageContext.request.contextPath}/deleteAllServlet" id="selectUser" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>
                <a class="btn btn-primary" onclick="selectAll()" >全选</a>
                <a class="btn btn-primary" onclick="isSelect()" >反选</a>
            </th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>手机号</th>
            <th>邮箱</th>
            <th>创建时间</th>
            <th>住宅</th>
            <th>用户账号</th>
            <th>操作</th>
        </tr>

       <c:forEach items="${pageBean.list}" var="user" varStatus="s">
        <tr>
            <td><input type="checkbox" name="uid" id="${user.name}" value="${user.id}"></td>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.sex}</td>
            <td>${user.mobil}</td>
            <td>${user.email}</td>
            <td>${user.create_time}</td>
            <td>${user.house}</td>
            <td>${user.username}</td>
            <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="javascript:deleteUser('${user.id}','${user.name}')">删除</a></td>
        </tr>
       </c:forEach>

    </table>
    </form>

    <nav aria-label="Page navigation">
        <ul class="pagination">
            <!--控制页面带参数与不带参数使用两个if判断其param是否含有参数
            forEach控制分页 也需要判断其带与不带参数
            -->
            <c:if test="${pageBean.totalPage==0}"><!--通过总页面判断页面是否为最后一页与第一页对向前向后按钮添加disable属性-->
                <li class="disabled" >
                    <span aria-hidden="true" hidden>&laquo;</span>
                </li>
            </c:if>
            <c:if test="${pageBean.currentPage==1&&pageBean.totalPage!=0}">
            <li class="disabled" >
                <span aria-hidden="true" >&laquo;</span>
            </li>
                </c:if>
                <c:if test="${pageBean.currentPage!=1}">
                    <c:if test="${!param.keySet().contains(\"name\")}"><!--判断是否带参-->
                    <li>
                        <a  href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pageBean.currentPage-1}" aria-label="Next">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    </c:if>
                    <c:if test="${param.keySet().contains(\"name\")}">
                        <li>
                            <a  href="${pageContext.request.contextPath}/findUserByPageServlet?${url}currentPage=${pageBean.currentPage-1}" aria-label="Next">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                </c:if>


            <c:if test="${param.keySet().contains(\"name\")}">
                <c:forEach  begin="1" end="${pageBean.totalPage}"  var="i" >

                    <c:if test="${pageBean.currentPage==i}"><!--在servlet内设置会话拼接传参URL，并接收参数-->
                        <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?${url}currentPage=${i}">${i}</a></li>
                    </c:if>
                    <c:if test="${pageBean.currentPage!=i}">
                        <li ><a href="${pageContext.request.contextPath}/findUserByPageServlet?${url}currentPage=${i}">${i}</a></li>
                    </c:if>

                </c:forEach>
            </c:if>
            <c:if test="${!param.keySet().contains(\"name\")}">
            <c:forEach  begin="1" end="${pageBean.totalPage}"  var="i" >

                    <c:if test="${pageBean.currentPage==i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}">${i}</a></li>
                    </c:if>
                    <c:if test="${pageBean.currentPage!=i}">
                        <li ><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}">${i}</a></li>
                    </c:if>

            </c:forEach>
            </c:if>
            <c:if test="${pageBean.totalPage==0}">
                <li class="disabled" >
                    <span aria-hidden="true" hidden>&raquo;</span>
                </li>
            </c:if>
            <c:if test="${pageBean.currentPage==pageBean.totalPage}">
                    <li class="disabled" >
                    <span aria-hidden="true" >&raquo;</span>
                    </li>
            </c:if>

            <c:if test="${pageBean.currentPage!=pageBean.totalPage&&pageBean.totalPage!=0}">
                <c:if test="${!param.keySet().contains(\"name\")}">
                <li>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pageBean.currentPage+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                </c:if>
                <c:if test="${param.keySet().contains(\"name\")}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?${url}currentPage=${pageBean.currentPage+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </c:if>
        </ul>
    </nav>
    <span style="font-size: 25px ;margin-left: 5px ">
        一共有${pageBean.totalCount}条数据,共${pageBean.totalPage}页
    </span>
</div>
</body>
</html>
