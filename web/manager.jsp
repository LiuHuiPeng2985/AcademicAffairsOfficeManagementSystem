<%--
  Created by IntelliJ IDEA.
  User: 86157
  Date: 2021/12/8
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员页面</title>
    <style>
        body{
            text-align: center;
        }
    </style>
</head>
<body>
<h2>请选择您要执行的功能</h2><br /><hr />
<table height="20%" width="20%" align="center" border="1" style="border-collapse:collapse;">
    <tr>
        <td align="center">
            <a href="register.jsp">注册</a>
        </td>
    </tr>
    <tr>
        <td align="center">
            <a href="${pageContext.request.contextPath}/checkController">查看</a>
        </td>
    </tr>
    <tr>
        <td align="center">
            <a href="delete.jsp">删除</a>
        </td>
    </tr>
    <tr>
        <td align="center">
            <a href="update.jsp">修改</a>
        </td>
    </tr>
</table><br />
<a href="login.jsp">退出登录</a>
</body>
</html>
