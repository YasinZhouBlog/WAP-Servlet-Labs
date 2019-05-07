<%@ page import="mum.cs472.Quiz" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/7
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NumberQuiz</title>
</head>
<body>
<%
    HttpSession s = request.getSession();
    Quiz q = (Quiz) s.getAttribute("quiz");
%>
<h3>Have fun with NumberQuiz!</h3>
<p>Your current score is: <%= q.getScore()%></p>
<p>You have completed the Number Quiz, with a score of <%= q.getScore()%> out of 5</p>
</body>
</html>
