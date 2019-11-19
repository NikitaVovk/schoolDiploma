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
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/mainAdmin/students">Uczni</a>
<a href="${pageContext.request.contextPath}/mainAdmin/teachers">Nauczyciele</a>
<a href="${pageContext.request.contextPath}/mainAdmin/classes">Klasy</a>
<a href="${pageContext.request.contextPath}/mainAdmin/subjects">Przedmioty</a>
<a href="${pageContext.request.contextPath}/mainAdmin/tsc">Zajęcia Klasy</a>
<a href="${pageContext.request.contextPath}/mainAdmin/plan">Plan Zajęć</a>
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

</body>
</html>
