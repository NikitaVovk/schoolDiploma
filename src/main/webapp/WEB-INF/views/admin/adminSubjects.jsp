<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 14/11/2019
  Time: 00:09
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

        <form method="post" action="${pageContext.request.contextPath}/mainAdmin/addSubject">
            <h2>Dodaj Przedmiot</h2>
            <label>Nazwa</label>
            <input type="text" name="name">
            <input type="Submit" value="Dodaj">
        </form>

        <table width="50%" border="2px solid blue">
            <c:set var="id" value="1"/>
            <tr>
                <td>ID</td>
                <td>Nazwa Przedmiotu</td>
            </tr>
            <c:forEach var="sub" items="${subjects}">
                <tr>
                    <td>${id}</td>
                    <td>${sub.name}</td>
                </tr>
                <c:set var="id" value="${id+1}"/>
            </c:forEach>
        </table>

    </jsp:body>
</t:tagAdmin>


</body>
</html>
