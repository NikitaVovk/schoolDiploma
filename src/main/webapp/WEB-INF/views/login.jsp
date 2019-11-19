<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 08/10/2019
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Security Example </title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">
    <div><label> User Name : <input type="text" name="username" id="username"/> </label></div>
    <div><label> Password: <input type="password" name="password" id="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>