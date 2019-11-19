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

<form method="get" action="${pageContext.request.contextPath}/mainAdmin/teachers">
    <h2>Znajdź nauczyciela</h2>
    <label>Nazwisko</label>
    <input type="text" name="surname">
    <label>Imie</label>
    <input type="text" name="name">
    <input type="Submit" value="Znajdź">
</form>
<a href="${pageContext.request.contextPath}/mainAdmin/teacherEditor">Dodaj nauczyciela</a>

<table width="100%" border="2px solid blue">

    <tr>
        <td>ID</td>
        <td>Nazwisko Imie</td>
        <td>Data urodzenia</td>
        <td>Klasa Wychowawcy</td>
    </tr>
    <c:forEach var="teacher" items="${teacherList}">
        <tr>
            <td>${teacher.idTeacher}</td>
            <td><a href="${pageContext.request.contextPath}/mainAdmin/teacherEditor?idTeacher=${teacher.idTeacher}">
                    ${teacher.surname} ${teacher.name}</a></td>
            <td>${teacher.dateOfBirth}</td>
            <td>${teacher.aClass.name}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
