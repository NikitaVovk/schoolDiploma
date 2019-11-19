<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 12/11/2019
  Time: 14:27
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
<a href="${pageContext.request.contextPath}/mainTeacher/showLesson">Zajęcia</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showMarks">Oceny</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showFrequency">Frekwencja</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showTest">Sprawdziany</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showPlan">Plan zajęć</a>

<h2>Dodaj sprawdzian</h2>
<form method="post" action="${pageContext.request.contextPath}/mainTeacher/addTest" >
    <input type="hidden" name="idTSC" value="${idTSC}">
    <input type="text" name="test">
    <select id="date" name="date" >
        <c:forEach var="dateItem" items="${datesLessons}">
            <option name="option" value="${dateItem.getTime()}">${dateItem.toString()}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Submit">
</form>

<table  width="50%" border="2px solid blue">
    <tr>
        <td>Sprawdzian</td>
        <td>Data</td>
        <td>Usuń</td>
    </tr>
    <c:set var="i" value="0"/>
    <c:forEach var="test" items="${tests}">
        <tr>
            <td>${test.test}</td>
            <td>${test.date}</td>
            <form method="post" action="${pageContext.request.contextPath}/mainTeacher/deleteTest">
                <input type="hidden" name="idTSC" value="${idTSC}">
                <input type="hidden" name="idTest" value="${i}">
                <td>
                <input type="submit" value="Usuń">
                </td>
            </form>
        </tr>
        <c:set var="i" value="${i+1}"/>
    </c:forEach>
</table>

</body>
</html>