<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 31/10/2019
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css" />
</head>
<body>
<t:tagStudent>
    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>

        <h1>Szkoła</h1>
        <table>
            <tr>
                <td>Nazwa szkoły:</td>
                <td></td>
            </tr>
            <tr>
                <td>Adres szkoły:</td>
                <td></td>
            </tr>
            <tr>
                <td>Telofon:</td>
                <td></td>
            </tr>
            <tr>
                <td>Dyrektor:</td>
                <td></td>
            </tr>
        </table>
        <h1>Nauczyciele</h1>
        <table width="50%" border="2px solid blue">
            <tr>
                <td>Lp.</td>
                <td>Przedmiot</td>
                <td>Nauczyciel</td>
            </tr>
            <c:set var="i" value="0"/>
            <c:forEach var="ts" items="${tsc}">
                <c:set var="i" value="${i=i+1}"/>
                <tr>
                    <td>${i}</td>
                    <td>${ts.subject.name}</td>
                    <td>${ts.teacher.name}</td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>
</t:tagStudent>



</body>
</html>
