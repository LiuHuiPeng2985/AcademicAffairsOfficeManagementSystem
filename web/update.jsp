<%--
  Created by IntelliJ IDEA.
  User: 86157
  Date: 2021/12/14
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
    <style>
        body{
            text-align: center;
        }
        span{
            color: blue;
        }
        span#tips{
            color: red;
        }
    </style>

    <script type="text/javascript">
        window.onload=function ()
        {
            var tDom = document.querySelector("div#t");
            tDom.style.display = "none";
            var sDom = document.querySelector("div#s");
            sDom.style.display = "none";

            var tipDom = document.querySelector("span#tips");
            var noneDom = document.querySelectorAll("input.none");
            noneDom[0].onclick=function () {
                    noneDom[0].value = "";
            }
            noneDom[1].onclick=function () {
                noneDom[1].value = "";
            }
            noneDom[2].onclick=function () {
                noneDom[2].value = "";
            }
            noneDom[3].onclick=function () {
                noneDom[3].value = "";
            }
            noneDom[4].onclick=function () {
                noneDom[4].value = "";
            }
            noneDom[5].onclick=function () {
                noneDom[5].value = "";
            }
            noneDom[6].onclick=function () {
                noneDom[6].value = "";
        }

            t=function (){
                tDom.style.display = "block";
                sDom.style.display = "none";
                tipDom.textContent="";
            }

            s=function () {
                tDom.style.display = "none";
                sDom.style.display = "block";
                tipDom.textContent="";
            }
        }
    </script>
</head>
<body>
<h3>请选择你要修改的信息</h3>
<input type="radio" name="type" value="teacher" onclick="t()">老师
<input type="radio" name="type" value="student" onclick="s()">学生<br />
<span id="tips">${errorUpdate}</span><br />
<div id="t">
    <form action="${pageContext.request.contextPath}/updateTeacherController" method="post">
        请输入<span>要修改</span>的账户:<br />
        <input type="text" name="username" value="例如:wangwu" class="none"><br /><br />
        请输入<span>修改后</span>的班级:<br />
        <input type="text" name="classes" value="例如:19计算机一班" class="none"><br /><br />
        请输入<span>修改后</span>的课程:<br />
        <input type="text" name="course" value="例如:JAVA" class="none"><br /><br />
        请输入<span>修改后</span>的时间:<br />
        <input type="text" name="time" value="例如:星期一" class="none"><br /><br />
        <input type="submit" value="确认修改">
        <a href="manager.jsp">返回</a>
    </form>
</div>
<div id="s">
    <form action="${pageContext.request.contextPath}/updateStudentController" method="post">
        请输入<span>要修改</span>的账户:<br />
        <input type="text" name="username" value="例如:wangwu" class="none"><br /><br />
        请输入<span>修改后</span>的课程:<br />
        <input type="text" name="course" value="例如:JAVA" class="none"><br /><br />
        请输入<span>修改后</span>的成绩:<br />
        <input type="text" name="score" value="例如:100" class="none"><br /><br />
        <input type="submit" value="确认修改">
        <a href="manager.jsp">返回</a>
    </form>
</div>
</body>
</html>
