<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 14/11/2019
  Time: 13:51
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
<form method="get" action="${pageContext.request.contextPath}/mainAdmin/plan">
    <label>Klasa</label>
    <select id="idClass" name="idClass">
        <option name="option" value="${null}" selected>Wszystkie</option>
        <c:forEach var="cl" items="${classes}">
            <c:set var="selected" value=""/>
            <c:if test="${idClass==cl.idclass}">
                <c:set var="selected" value="selected"/>
            </c:if>
            <option name="option" value="${cl.idclass}" ${selected}>${cl.name}</option>
        </c:forEach>
    </select>
    <input type="Submit" value="Znajdź">
</form>
<c:if test="${idClass!=null}">

    <form method="post" action="${pageContext.request.contextPath}/mainAdmin/savePlan">

    <input type="hidden" name="idClass" value="${idClass}">
<table width="100%" border="2px solid blue">
    <tr>
        <td>Lekcja</td>
        <td>Pora lekcji</td>
        <c:forEach var="day" items="${datesString}">
            <td>${day.name}</td>
        </c:forEach>
    </tr>
    <c:forEach var="lesson" items="${lessonTime}">
        <tr>
            <td>${lesson.id}.</td>
            <td>${lesson.timeStart}
                    ${lesson.timeEnd}</td>

            <c:forEach var="date" items="${datesString}">
                <c:set var="teacherS" value="${null}"/>
                <c:set var="subjectS" value="${null}"/>

                <td>
                    <c:forEach var="tt" items="${timeTable}">
                        <c:if test="${tt.lessonTime.id==lesson.id && tt.daysOfWeek.id == date.id}">
<%--                            ${tt.teacherSubjectClass.subject.name}--%>
                            <c:set var="teacherS" value="${tt.teacherSubjectClass.teacher}"/>
                            <c:set var="subjectS" value="${tt.teacherSubjectClass.subject}"/>
                        </c:if>
                    </c:forEach>

                    <p><strong>Zajęcie</strong></p>

                    <select id="idTSC" name="idTSC">
                        <option name="option" value="${null}" selected>-</option>
                        <c:forEach var="tscItem" items="${tsc}">
                            <c:set var="selected" value=""/>
                            <c:if test="${teacherS.idTeacher==tscItem.teacher.idTeacher &&
                            subjectS.idsubject==tscItem.subject.idsubject}">
                                <c:set var="selected" value="selected"/>
                            </c:if>
                            <option name="option" value="${tscItem.id}" ${selected}>${tscItem.subject.name} - ${tscItem.teacher.surname} ${tscItem.teacher.name}</option>
                        </c:forEach>
                    </select>


                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
        <input type="submit" value="Zapisz plan">
    </form>
</c:if>
</body>
</html>
