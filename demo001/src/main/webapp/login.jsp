<%--
  Created by IntelliJ IDEA.
  User: CZQ
  Date: 2021/10/30
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/loginTestDemo" method="post" style="align-content: center" >
    <table >
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" style="margin: 5px"></td>
        </tr>
        <tr>
            <td>密码</td>
                <td><input type="password" name="password" style="margin: 5px"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="check" style="margin: 5px"></td>
        </tr>
        <tr>
            <td><img id="checkimg" src="/checkCodeServlet" onclick="fun()"style="margin: 5px ;column-span: 2"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"style="margin: 5px"></td>
        </tr>
    </table>
</form>

    <div><%=request.getAttribute("cc_error")==null?"":request.getAttribute("cc_error")%></div>
    <div><%=request.getAttribute("user_error")==null?"":request.getAttribute("user_error")%></div>


</form>
<br>
</body>
</html>
<script>

    var checkimg = document.getElementById("checkimg");
    function fun(){
        var time = new Date().getTime();
        checkimg.src="/checkCodeServlet?"+time
    }







</script>