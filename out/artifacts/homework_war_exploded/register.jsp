<%--
  Created by IntelliJ IDEA.
  User: 86157
  Date: 2021/12/10
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        body{
            text-align: center;
        }
        span{
            color: red;
            font-size: 20px;
        }
    </style>
</head>
<body>
<h2>注册</h2><hr />
<%--@declare id="student"--%><%--@declare id="teacher"--%><%--@declare id="manager"--%>
<form action="${pageContext.request.contextPath}/register" method="post">
    请确保身份不为空，否则注册失败<br />
    请选择你要注册身份：
    <label for="student">学生</label><input type="radio" name="type" value="student">
    <label for="teacher">教师</label><input type="radio" name="type" value="teacher">
    <label for="manager">管理员</label><input type="radio" name="type" value="manager"><br />
    账号:<input type="text" name="username" required><br />
    密码:<input type="password" name="password" required><br />
    <span>${errorRegister}</span><br />
    <input type="submit" value="提交">
    <p><a href="/manager.jsp">退出注册</a></p><br />
</form>
</body>
</html>
