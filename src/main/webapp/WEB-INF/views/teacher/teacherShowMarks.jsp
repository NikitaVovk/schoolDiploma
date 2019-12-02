<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 12/11/2019
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/teacher/index.css" />

</head>
<body>
<t:tagTeacher>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div style="display: grid; grid-auto-flow: column;">
            <div id = "tabName">
                <p>Oceny</p>
            </div>
            <div class="selectClass">
                <div style="display: grid;justify-content: center;align-content: center; margin-bottom: 3px; font-size: 13px;"><p>Wybierz klasę</p></div>
                <select id="idTSC" name="idTSC"  class="selectorClass" onchange="location = this.value;" >
                    <option name="option" value="${pageContext.request.contextPath}/mainTeacher/showMarks" selected>-</option>

                    <c:forEach var="aClass" items="${classList}">
                        <c:set var="selected" value=""/>
                        <c:if test="${aClass.id==idTSC}">
                            <c:set var="selected" value="selected"/>
                        </c:if>
                        <option name="option" value="${pageContext.request.contextPath}/mainTeacher/showMarks?idTSC=${aClass.id}" ${selected}>${aClass.subject.name} - ${aClass.aClass.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="hr">
            <hr>
        </div>

            <c:if test="${idTSC!=null}">
        <div id="tabNameInfo" style="font-size: 20px;">
            <p>Przedmiot - <b>"${tsc.subject.name}"</b>, klasa - <b>"${tsc.aClass.name}"</b></p>

        </div>

        <div id="tabNameInfo">
            <p>Oceny uczniów uzyskane w tym semestrze</p>
        </div>

        <table  width="100%" border="2px solid blue">
            <tr>
                <th>№</th>
                <th>Uczeń</th>
                <th>Oceny</th>
            </tr>
            <c:set var="i" value="0"/>
            <c:forEach var="student" items="${listStudents}">
                <tr>
                    <td>${i+1}</td>
                    <td>${student.name} ${student.surname}</td>
                    <td>
                        <c:forEach var="mark" items="${markList.get(i)}">
                            ${mark.mark}
                        </c:forEach>
                    </td>
                    <c:set var="i" value="${i+1}"/>
                </tr>
            </c:forEach>
        </table>
        </c:if>
    </jsp:body>
</t:tagTeacher>

</body>
</html>
