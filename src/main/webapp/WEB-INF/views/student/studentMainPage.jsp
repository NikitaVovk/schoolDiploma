<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 08/10/2019
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css" />
</head>
<body>

<p>Hello, ${student.name} ${student.surname}</p>
<a href="${pageContext.request.contextPath}/mainStudent/">Uczen</a>
<form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>


</body>
</html>
