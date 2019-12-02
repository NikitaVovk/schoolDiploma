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
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/index.css" />

</head>
<body>
<t:tagAdmin>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>


        <div style="display: grid; grid-auto-flow: column;">
            <div id = "tabName">
                <p>Plan zajęć</p>
            </div>
            <div class="selectClass">
                <div style="display: grid;justify-content: center;align-content: center; margin-bottom: 3px; font-size: 13px;"><p>Wybierz klasę</p></div>
                <select id="idClass" name="idClass"  class="selectorClass" onchange="location = this.value;" >
                    <option name="option" value="${pageContext.request.contextPath}/mainAdmin/tsc" selected>-</option>

                    <c:forEach var="oneClass" items="${classes}">
                        <c:set var="selected" value=""/>
                        <c:if test="${oneClass.idclass==classId}">
                            <c:set var="selected" value="selected"/>
                        </c:if>
                        <option name="option" value="${pageContext.request.contextPath}/mainAdmin/plan?idClass=${oneClass.idclass}" ${selected}>${oneClass.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="hr">
            <hr>
        </div>
        <div id="tabNameInfo" style="font-size: 20px;">
            <p>Plan zajęć klasy <strong>${aClass.name}</strong></p>
        </div>

        <div class="smallHr">
            <hr>
        </div>


<%--        <form method="get" action="${pageContext.request.contextPath}/mainAdmin/plan">--%>
<%--            <label>Klasa</label>--%>
<%--            <select id="idClass" name="idClass">--%>
<%--                <option name="option" value="${null}" selected>Wszystkie</option>--%>
<%--                <c:forEach var="cl" items="${classes}">--%>
<%--                    <c:set var="selected" value=""/>--%>
<%--                    <c:if test="${idClass==cl.idclass}">--%>
<%--                        <c:set var="selected" value="selected"/>--%>
<%--                    </c:if>--%>
<%--                    <option name="option" value="${cl.idclass}" ${selected}>${cl.name}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--            <input type="Submit" value="Znajdź">--%>
<%--        </form>--%>



        <c:if test="${classId!=null}">

            <form method="post" action="${pageContext.request.contextPath}/mainAdmin/savePlan">
                <div style="margin: 20px; display:grid; align-content: center;justify-content: center;">

                <input type="submit" value="Zapisz plan" class="smallSubmit" style="justify-self: center;">


                </div>
                <input type="hidden" name="idClass" value="${classId}">
                <table width="100%" border="2px solid blue" style="font-size: 16px;">
                    <tr>
                        <th>№</th>
                        <th><p>Pora</p>
                            <p>lekcji</p></th>
                        <c:forEach var="day" items="${datesString}">
                            <th>${day.name}</th>
                        </c:forEach>
                    </tr>
                    <c:forEach var="lesson" items="${lessonTime}">
                        <tr>
                            <td>${lesson.id}</td>
                            <td><p>${lesson.timeStart.toLocalTime()}</p>
                                <p> ${lesson.timeEnd.toLocalTime()}</p></td>

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
                                    <div class="dayBook">
                                    <p><strong>Zajęcie</strong></p>

                                    <select id="idTSC" name="idTSC" class="selectorTSC">
                                        <option name="option" value="${null}" selected>-</option>
                                        <c:forEach var="tscItem" items="${tsc}">
                                            <c:set var="selected" value=""/>
                                            <c:if test="${teacherS.idTeacher==tscItem.teacher.idTeacher &&
                            subjectS.idsubject==tscItem.subject.idsubject}">
                                                <c:set var="selected" value="selected"/>
                                            </c:if>
                                            <option name="option" value="${tscItem.id}" ${selected}><p>${tscItem.subject.name}</p> - <p>${tscItem.teacher.surname} ${tscItem.teacher.name}</p></option>
                                        </c:forEach>
                                    </select>
                                    </div>


                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>

            </form>
        </c:if>
    </jsp:body>
</t:tagAdmin>

</body>
</html>
