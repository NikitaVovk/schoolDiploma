<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 08/10/2019
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Spring Security Example </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" />

</head>
<body>

<t:tagLogin>
<jsp:attribute name="header">

    </jsp:attribute>
<jsp:attribute name="footer">

    </jsp:attribute>
<jsp:body>
    <div id="container">
<div id="logginForm">
    <div id="zaloguj">
        <div>
        <p>Zaloguj się</p>
        </div>
    </div>
    <div id="hr">
        <hr>
    </div>
        <form action="${pageContext.request.contextPath}/login" method="post">
<div class="login">
    <div>
            <label for="username">Username:</label>
<div class="whiteHr">
    <hr>
</div>
            <input class="data" type="text" id="username" name="username" style="width: 260px">
    </div>
</div>
            <div class="login">
            <label for="password">Password:</label>

                <div class="whiteHr">
                    <hr>
                </div>
            <input type="password"  class="data" id="password" name="password" style="width: 260px">

            </div>

            <div class="loginSubmit">
<div>
                <input type="submit" value="Login" style="background: rgba(57, 106, 203,0.9);">
</div>
            </div><!--/ lower-->

        </form>
</div>
    </div><!--/ container-->

</jsp:body>
</t:tagLogin>
</body>
</html>