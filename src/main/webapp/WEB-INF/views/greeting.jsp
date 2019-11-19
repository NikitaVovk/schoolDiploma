<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 25/09/2019
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Hello world!!!</p>
<a href="${pageContext.request.contextPath}/mainTeacher">Main page</a>
<form action="${pageContext.request.contextPath}/main" method="get">
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>
