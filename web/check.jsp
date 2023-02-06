<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86157
  Date: 2021/12/13
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看</title>
    <style>
        h3{
            font-size: 20px;
            position: absolute;
            left: 20%;
            text-align: left;
        }
    </style>
</head>
<body>
<h3><a href="manager.jsp">返回</a></h3><br /><br /><hr />
<table width="40%" align="center" border="1" style="border-collapse:collapse;">
    <thead>
    <tr>
        <th>用户名</th>
        <th>身份</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${see}">
        <tr>
            <td>${user.username}</td>
            <td>${user.type}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
