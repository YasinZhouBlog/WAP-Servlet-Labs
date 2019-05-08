<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/7
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Beer Selection Page</title>
  </head>
  <body>
  <h1 align="center">Beer Selection Page</h1>
  <form method="post" action="./BeerServlet">
    Select beer characteristics<p>
    Color:
    <select name="color" size="1">
      <option value="light">light</option>
      <option value="amber">amber</option>
      <option value="brown">brown</option>
      <option value="dark">dark</option>
    </select>
    <br><br>
    <div align="center">
      <input type="submit">
    </div>
  </form>
  </body>
</html>
