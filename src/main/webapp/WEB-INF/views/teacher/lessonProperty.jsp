<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 15/10/2019
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <p>Zajęcia</p>
            </div>
        <div class="selectClass">
    <div style="display: grid;justify-content: center;align-content: center; margin-bottom: 3px; font-size: 13px;"><p>Wybierz klasę</p></div>
            <select id="idTSC" name="idTSC"  class="selectorClass" onchange="location = this.value;" >
                <option name="option" value="${pageContext.request.contextPath}/mainTeacher/showLesson" selected>-</option>
                <c:set var="tsc" value="0"/>
                <c:forEach var="aClass" items="${classList}">
                    <c:set var="selected" value=""/>
                    <c:if test="${tsc==idTSC}">
                        <c:set var="selected" value="selected"/>
                    </c:if>
                    <option name="option" value="${pageContext.request.contextPath}/mainTeacher/showLesson?idTSC=${tsc}" ${selected}>${aClass.subject.name} - ${aClass.aClass.name}</option>
                    <c:set var="tsc" value="${tsc+1}"/>
                </c:forEach>
            </select>
            </div>
        </div>

<%--        <div style="display: grid;justify-content: center;align-content: center; margin-bottom: 3px; font-size: 13px;"><p>Wybierz klasę</p></div>--%>
<%--        <select id="idTSC" name="idTSC"  class="selectorClass" onchange="location = this.value;" >--%>
<%--            <option name="option" value="${pageContext.request.contextPath}/mainTeacher/showLesson" selected>-</option>--%>

<%--            <c:forEach var="aClass" items="${classList}">--%>
<%--                <c:set var="selected" value=""/>--%>
<%--                <c:if test="${aClass.id==idTSC}">--%>
<%--                    <c:set var="selected" value="selected"/>--%>
<%--                </c:if>--%>
<%--                <option name="option" value="${pageContext.request.contextPath}/mainTeacher/showLesson?idTSC=${aClass.id}" ${selected}>${aClass.subject.name} - ${aClass.aClass.name}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
<%--        </div>--%>
<%--        </div>--%>

        <div class="hr">
            <hr>
        </div>
<c:if test="${idTSC!=null}">
        <div id="tabNameInfo" style="font-size: 20px;">
            <p>Zajęcia: przedmiot - <b>"${className.subject.name}"</b>, klasa - <b>"${className.aClass.name}"</b>. Data <b>${dateChosen}</b></p>

        </div>


<%--        <table width="100%" border="2px solid blue">--%>
<%--            <tr>--%>
<%--                <c:forEach var="dateItem" items="${datesLessons}">--%>
<%--                    <c:set var="colorDate" value="darkgreen"/>--%>
<%--                    <c:if test="${dateItem.equals(dateChosen)}">--%>
<%--                        <c:set var="colorDate" value="blue"/>--%>
<%--                    </c:if>--%>

<%--                    <td> <a style="color: ${colorDate}" href="${pageContext.request.contextPath}/mainTeacher/showLesson?idTSC=${idTSC}&date=${dateItem.getTime()}">${dateItem.toString()}</a></td>--%>

<%--                </c:forEach>--%>
<%--            </tr>--%>

<%--        </table>--%>


        <form method="get" action="${pageContext.request.contextPath}/mainTeacher/showLesson" >
            <input type="hidden" name="idTSC" value="${idTSC}">
            <div class="selectDate">
            <select id="date" name="date"  class="selectorDate" style="margin-right: 25px;">
                <c:forEach var="dateItem" items="${datesLessons}">
                    <c:set var="selected" value=""/>
                    <c:if test="${dateItem.equals(dateChosen)}">
                        <c:set var="selected" value="selected"/>
                    </c:if>
                    <option name="option" value="${dateItem.getTime()}" ${selected}>${dateItem.toString()}</option>
                </c:forEach>
            </select>

            <input class="smallSubmit" type="submit" value="Zmień" style="margin-left: 25px;">
            </div>
        </form>

        <div class="smallHr">
            <hr>
        </div>

        <div class="lessonProperties">

        <form method="post" action="${pageContext.request.contextPath}/mainTeacher/addLessonTheme?idTSC=${idTSC}&date=${dateChosen.getTime()}">
            <div class="lessonTheme">
            <h2>Temat zajęcia</h2>
            <input type="text" name="lessonTheme"value="${lessonTheme.theme}" class="ltAndHm">
            <div class="centerSub">
            <input type="submit" value="Zatwierdź" class="smallSubmit">
            </div>
            </div>
        </form>


        <form method="post" action="${pageContext.request.contextPath}/mainTeacher/addHomeWork?idTSC=${idTSC}&date=${dateChosen.getTime()}">
            <div class="lessonHM">
            <h2>Zadanie domowe</h2>
            <input type="text" name="homeWork"value="${homeWork.homeWork}" class="ltAndHm">
            <div class="centerSub">
                <input type="submit" value="Zatwierdź" class="smallSubmit">
            </div>
            </div>
        </form>
            </div>

        <div class="smallHr" style="margin-bottom: 20px">
            <hr>
        </div>


    <div class="prevNext">
        <div id="prev">
            <a href="${pageContext.request.contextPath}/mainTeacher/showLesson?idTSC=${idTSC}&date=${prevLessonDate.getTime()}" class="links2">Poprzednie zajęcie</a>
        </div>
        <div id="next">
            <a href="${pageContext.request.contextPath}/mainTeacher/showLesson?idTSC=${idTSC}&date=${nextLessonDate.getTime()}" class="links2">Następne zajęcie</a>
        </div>
    </div>

        <form method="post" action="${pageContext.request.contextPath}/mainTeacher/saveProperties?idTSC=${idTSC}&date=${dateChosen.getTime()}">

            <table width="100%" border="2px solid blue">
                <tr>
                    <th>№</th>
                    <th>Uczeń</th>
                    <th>Ocena</th>
                </tr>
                <c:set var="iterator" value="0"/>
                <c:forEach var="listItem" items="${listStudents}"  >
                    <c:set var="iterator" value="${iterator+1}"/>

                    <c:set var="val" value=""/>


                    <tr>
                    <td>
                            ${iterator}
                    </td>
                        <td> <p>${listItem.surname} ${listItem.name} </p> </td>

                        <c:forEach var="freq" items="${freqDate}">
                            <c:choose>
                                <c:when test="${freq.student.idstudent==listItem.idstudent}">
                                    <c:set var="val" value="n"/>
                                </c:when>
                            </c:choose>
                        </c:forEach>


                        <c:forEach var="marks" items="${marksDate}">
                            <c:choose>
                                <c:when test="${marks.student.idstudent==listItem.idstudent}">
                                    <%--                                <td><p>${markListItem.mark}   ${markListItem.date.getMonth() }  ${dateItem.getTime().getMonth()}</p></td>--%>

                                    <c:set var="val" value="${marks.mark}"/>
                                </c:when>
                                <c:otherwise>

                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <td><input type="text" value="${val}" name="studentProp" class="markInput"></td>

                    </tr>
                </c:forEach>

            </table>
            <div class="centerSub" style="margin-top: 30px">
            <input type="submit" value="Zatwierdź">
            </div>
        </form>
</c:if>
<%--        <a href="${pageContext.request.contextPath}/mainTeacher/showAll?idTSC=${idTSC}">Show All Marks</a>--%>
<%--        <a href="${pageContext.request.contextPath}/mainTeacher">Main page</a>--%>
    </jsp:body>
</t:tagTeacher>


</body>
</html>









