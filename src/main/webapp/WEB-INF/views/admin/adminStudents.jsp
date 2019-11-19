<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 13/11/2019
  Time: 14:20
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

<form method="get" action="${pageContext.request.contextPath}/mainAdmin/students">
    <h2>Znajdź ucznia</h2>
    <label>Nazwisko</label>
    <input type="text" name="surname">
    <label>Imie</label>
    <input type="text" name="name">
    <input type="Submit" value="Znajdź">
</form>

<form method="get" action="${pageContext.request.contextPath}/mainAdmin/students">
    <label>Klasa</label>
<select id="idClass" name="idClass">
    <option name="option" value="${null}" selected>Wszystkie</option>
    <c:forEach var="cl" items="${classes}">
        <option name="option" value="${cl.idclass}">${cl.name}</option>
    </c:forEach>
</select>
    <input type="Submit" value="Znajdź">
</form>

<a href="${pageContext.request.contextPath}/mainAdmin/studentEditor">Dodaj ucznia</a>
<br>

<table width="100%" border="2px solid blue">

    <tr>
        <td>ID</td>
        <td>Nazwisko Imie</td>
        <td>Data urodzenia</td>
        <td>Klasa</td>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.idstudent}</td>
            <td><a href="${pageContext.request.contextPath}/mainAdmin/studentEditor?idStudent=${student.idstudent}">
                    ${student.surname} ${student.name}</a></td>
            <td>${student.dateOfBirth}</td>
            <td>${student.aClass.name}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
