<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 13/11/2019
  Time: 22:20
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
<c:set var="url" value=""/>
<c:set var="addOrEdit" value=""/>
<c:choose>
    <c:when test="${teacher==null}">
        <c:set var="url" value="addTeacher"/>
        <c:set var="addOrEdit" value="Dodaj"/>
    </c:when>
    <c:otherwise>
        <c:set var="url" value="editTeacher?idTeacher=${teacher.idTeacher}"/>
        <c:set var="addOrEdit" value="Edytuj"/>
    </c:otherwise>
</c:choose>

<form method="post" action="${pageContext.request.contextPath}/mainAdmin/${url}">
    <h2>${addOrEdit} nauczyciela</h2>
    <label>Nazwisko</label>
    <input type="text" name="surname" value="${teacher.surname}">
    <label>Imie</label>
    <input type="text" name="name" value="${teacher.name}">
    <label>Klasa</label>

    <select id="aClass" name="aClass" >
        <option name="option" value="${null}" selected>-</option>
        <c:forEach var="cl" items="${classes}">
            <c:set var="selected" value=""/>
            <c:if test="${teacher.aClass.idclass==cl.idclass}">
                <c:set var="selected" value="selected"/>
            </c:if>
            <option name="option" value="${cl.idclass}" ${selected}>${cl.name}</option>

        </c:forEach>
    </select>
    <label>Data urodzenia</label>
    <input type="date" name="dateOfBirth" min="1940-01-01" max="2015-12-31" value="${teacher.dateOfBirth}">
    <input type="Submit" value="Zatwierdź">
</form>

</body>
</html>
