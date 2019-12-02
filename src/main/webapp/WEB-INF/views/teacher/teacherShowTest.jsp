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
                <p>Sprawdziany</p>
            </div>
            <div class="selectClass">
                <div style="display: grid;justify-content: center;align-content: center; margin-bottom: 3px; font-size: 13px;"><p>Wybierz klasę</p></div>
                <select id="idTSC" name="idTSC"  class="selectorClass" onchange="location = this.value;" >
                    <option name="option" value="${pageContext.request.contextPath}/mainTeacher/showTest" selected>-</option>

                    <c:forEach var="aClass" items="${classList}">
                        <c:set var="selected" value=""/>
                        <c:if test="${aClass.id==idTSC}">
                            <c:set var="selected" value="selected"/>
                        </c:if>
                        <option name="option" value="${pageContext.request.contextPath}/mainTeacher/showTest?idTSC=${aClass.id}" ${selected}>${aClass.subject.name} - ${aClass.aClass.name}</option>
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



            <div class="midTable">
        <table   border="2px solid blue">
            <tr>
                <th>№</th>
                <th>Sprawdzian</th>
                <th>Data</th>
                <th>Usuń</th>
            </tr>
            <c:set var="i" value="0"/>
            <c:forEach var="test" items="${tests}">
                <tr>
                    <td>${i+1}</td>
                    <td>${test.test}</td>
                    <td>${test.date}</td>
                    <form method="post" action="${pageContext.request.contextPath}/mainTeacher/deleteTest">
                        <input type="hidden" name="idTSC" value="${idTSC}">
                        <input type="hidden" name="idTest" value="${i}">
                        <td>
                            <input type="submit" value="Usuń" class="smallSubmit">
                        </td>
                    </form>
                </tr>
                <c:set var="i" value="${i+1}"/>
            </c:forEach>
        </table>
            </div>
        <div style="display:grid;align-content: center;justify-content: center;">
            <form method="post" action="${pageContext.request.contextPath}/mainTeacher/addTest" >
                <div class="addTest">
                    <h2>Dodaj sprawdzian</h2>
                    <input type="hidden" name="idTSC" value="${idTSC}">
                    <p>Wpisz temat sprawdzianu</p>
                    <input type="text" name="test" class="ltAndHm">
                    <div >
                        <hr>
                    </div>
                    <p>Wybierz datę sprawdzianu</p>
                    <div style="display: grid;align-content: center;justify-content: center;">
                        <select id="date" name="date" style="margin-top: 15px" >
                            <c:forEach var="dateItem" items="${datesLessons}">
                                <option name="option" value="${dateItem.getTime()}">${dateItem.toString()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="centerSub">
                        <input type="submit" value="Dodaj" class="smallSubmit">
                    </div>
                </div>
            </form>
        </div>
    </c:if>
    </jsp:body>
</t:tagTeacher>


</body>
</html>
