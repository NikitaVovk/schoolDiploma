<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 12/11/2019
  Time: 23:08
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

        <div id = "tabName">
            <p>Plan zajęć</p>
        </div>

        <div class="hr">
            <hr>
        </div>

        <div id="tabNameInfo">

        </div>

        <div id="tabWeek">
            <p>Tydzień  ${dates.get(0).toString()} - ${dates.get(dates.size()-1).toString()}</p>

            <hr>

        </div>



        <div class="prevNext">
            <div id="prev">
                <a href="${pageContext.request.contextPath}/mainTeacher/showPlan?date=${prevWeek.getTime()}" class="links2">Poprzedni tydzien</a>
            </div>
            <div id="next">
                <a href="${pageContext.request.contextPath}/mainTeacher/showPlan?date=${nextWeek.getTime()}" class="links2">Następny tydzien</a>
            </div>
        </div>


        <table width="100%" border="2px solid blue" style="font-size: 16px;">
            <tr>
                <th>№</th>
                <th><p>Pora</p><p>lekcji</p></th>
                <c:forEach var="day" items="${datesString}">
                    <th>${day.name}
                            ${dates[day.id-2].toString()}</th>
                </c:forEach>
            </tr>
            <c:forEach var="lesson" items="${lessonTime}">
                <tr>
                    <td>${lesson.id}</td>
                    <td>${lesson.timeStart.toLocalTime()}
                            ${lesson.timeEnd.toLocalTime()}</td>

                    <c:forEach var="date" items="${datesString}">
                        <td>
                            <c:forEach var="tt" items="${timeTable}">
                                <c:if test="${tt.lessonTime.id==lesson.id && tt.daysOfWeek.id == date.id}">
                                    <p><strong>${tt.teacherSubjectClass.subject.name}</strong></p>
                                    <p>${tt.teacherSubjectClass.aClass.name}</p>
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
<%--        <a href="${pageContext.request.contextPath}/mainTeacher/showPlan?date=${prevWeek.getTime()}">Poprzedni tydzien</a>--%>
<%--        <a href="${pageContext.request.contextPath}/mainTeacher/showPlan?date=${nextWeek.getTime()}">Następny tydzien</a>--%>
    </jsp:body>
</t:tagTeacher>

</body>
</html>
