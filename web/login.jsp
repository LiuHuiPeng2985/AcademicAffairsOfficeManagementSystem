<%--
  Created by IntelliJ IDEA.
  User: 86157
  Date: 2021/12/7
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style>
        body{
            text-align: center;
        }
        span{
            color: red;
            font-size: 20px;
        }
        div{
            position: absolute;
            top: 15%;
            left: 37%;
            font-size: 20px;
        }
        /*h1{*/
        /*    background-color: burlywood;*/
        /*}*/
        /*form{*/
        /*    background-color: aquamarine;*/
        /*}*/
    </style>
</head>
<body>
<table border="1.5">
    <div>
        <h1>登录<br /><hr /></h1>
        <%--@declare id="student"--%><%--@declare id="teacher"--%><%--@declare id="manager"--%>
        <form action="${pageContext.request.contextPath}/login" method="post">
            请选择你的登录身份：
            <label for="student">学生</label><input type="radio" name="type" value="student">
            <label for="teacher">教师</label><input type="radio" name="type" value="teacher">
            <label for="manager">管理员</label><input type="radio" name="type" value="manager"><br />
            账号:<input type="text" name="username" required><br />
            密码:<input type="password" name="password" required><br />
            验证码:<input type="text" name="inputVcode"><br /><img src="${pageContext.request.contextPath}/createCode"><br />
            <span>${errorLogin}</span><br />
            <input type="submit" value="登录">
        </form>
    </div>
</table>
</body>
</html>
