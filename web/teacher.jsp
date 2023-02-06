<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>老师页面</title>
    <style>
        body{
            text-align: center;
        }
        p{
            font-size: 30px;
            position: absolute;
            left: 20%;
            text-align: left;
        }
        table{
            text-align: center;
        }
    </style>
</head>
<body>
<p>欢迎:${requestScope.key}</p><br /><br /><br />
<p><a href="/login.jsp">退出登录</a></p><br />
<h1>课 程</h1><hr />
<table width="40%" align="center" border="1" style="border-collapse:collapse;">
    <thead>
    <tr>
        <th>班级</th>
        <th>课程</th>
        <th>时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="teacher" items="${curriculum}">
        <tr>
            <td>${teacher.classes}</td>
            <td>${teacher.course}</td>
            <td>${teacher.time}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
