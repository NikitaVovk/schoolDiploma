<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 13/11/2019
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<t:tagAdmin>
    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>
        <form method="post" action="${pageContext.request.contextPath}/mainAdmin/addClass">
            <h2>Dodaj Klasę</h2>
            <label>Nazwa</label>
            <input type="text" name="name">
            <input type="Submit" value="Dodaj">
        </form>

        <table width="50%" border="2px solid blue">
            <c:set var="id" value="1"/>
            <tr>
                <td>ID</td>
                <td>Nazwa Klasy</td>
            </tr>
            <c:forEach var="cl" items="${classes}">
                <tr>
                    <td>${id}</td>
                    <td>${cl.name}</td>
                </tr>
                <c:set var="id" value="${id+1}"/>
            </c:forEach>
        </table>
    </jsp:body>
</t:tagAdmin>



</body>
</html>
