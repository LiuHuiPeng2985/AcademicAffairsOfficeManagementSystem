<%--
  Created by IntelliJ IDEA.
  User: 86157
  Date: 2021/12/13
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除用户</title>
    <style>
        body{
            text-align: center;
        }
        span{
            color: red;
        }
    </style>
</head>
<body>
<h2>删除系统</h2><hr />
<form action="${pageContext.request.contextPath}/deleteUserController" method="post">
    请输入你要删除的用户账号:<br /><br />
    <input type="text" name="username" required><br />
    <span>${delete}</span><br />
    <input type="submit" value="确认删除">
    <a href="manager.jsp">返回</a>
</form>
</body>
</html>
