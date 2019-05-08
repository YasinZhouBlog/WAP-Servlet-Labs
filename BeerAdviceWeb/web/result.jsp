<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/7
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1 align="center">Beer Recommendations JSP</h1>
<%--<%--%>
<%--    List styles = (List)request.getSession().getAttribute("result");--%>
<%--    Iterator it = styles.iterator();--%>
<%--    while(it.hasNext()) {--%>
<%--        out.print("<br>try: " + it.next());--%>
<%--    }--%>
<%--%>--%>
<c:forEach var="it" items="${result}">
    <br>try: ${it}
</c:forEach>

</body>
</html>
