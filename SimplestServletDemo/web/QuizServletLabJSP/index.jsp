<%@ page import="mum.cs472.Quiz" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/7
  Time: 14:34
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
<form method='post' action="./QuizServletLabJsp">
<h3>Have fun with NumberQuiz!</h3>
<p>Your current score is: <%= ((Quiz)request.getSession().getAttribute("quiz")).getScore() %></p>
<p>Guess the next number in the sequence! </p>
<p><%= q.getQuestion() %></p>
<p>Your answer: <input type='text' name='answer'/></p>
<input type='submit'/></p>
</form>
</body>
</html>
