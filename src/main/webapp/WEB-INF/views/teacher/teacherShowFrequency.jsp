<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 12/11/2019
  Time: 15:50
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

<h2>Obecność klasy ${tsc.aClass.name} Przedmiot ${tsc.subject.name}</h2>

<table  width="50%" border="2px solid blue">
    <tr>
        <td>Uczeń</td>
        <td>Liczba nieobecności</td>
        <td>Procent obecności</td>
    </tr>
    <c:set var="i" value="0"/>
    <c:forEach var="student" items="${listStudents}">
        <tr>
            <td>${student.name} ${student.surname}</td>
            <td>
                ${freqList.get(i).size()}
            </td>
            <td>${freqPercent.get(i)}</td>
            <c:set var="i" value="${i+1}"/>
        </tr>
    </c:forEach>
</table>

</body>
</html>
