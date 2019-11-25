<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 30/10/2019
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css" />
</head>
<body>
<t:tagStudent>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>
        <div id = "tabName">
            <p>Dziennik</p>
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
                <a href="${pageContext.request.contextPath}/mainStudent/dayBook?date=${prevWeek.getTime()}" class="links2">Poprzedni tydzien</a>
            </div>
            <div id="next">
                <a href="${pageContext.request.contextPath}/mainStudent/dayBook?date=${nextWeek.getTime()}" class="links2">Następny tydzien</a>
            </div>
        </div>



        <table width="100%" border="2px solid blue" style="font-size: 16px;">
            <tr>
                <th>№</th>
                <th><p>Pora</p>
                    <p>lekcji</p></th>
                <c:forEach var="day" items="${datesString}">
                    <th><p>${day.name}</p>
                           <p>${dates[day.id-2].toString()}</p></th>
                </c:forEach>
            </tr>
            <c:forEach var="lesson" items="${lessonTime}">
                <tr>
                    <td>${lesson.id}</td>
                    <td><p>${lesson.timeStart.toLocalTime()}</p>
                           <p> ${lesson.timeEnd.toLocalTime()}</p></td>

                    <c:forEach var="date" items="${datesString}">
                        <td>
                            <div class="dayBook">
                            <c:forEach var="tt" items="${timeTable}">
                                <c:if test="${tt.lessonTime.id==lesson.id && tt.daysOfWeek.id == date.id}">
                                   <p>${tt.teacherSubjectClass.subject.name}</p>

                                    <div style="display: grid;justify-content: center;align-content: center">
                                    <c:forEach var="freq" items="${frequency[date.id-2]}">
                                        <c:if test="${tt.teacherSubjectClass.subject.idsubject==freq.subject.idsubject}">
                                            <div class="freq">
                                            <p style="font-size: 18px; width: 10px;"><strong>${freq.frequency}</strong></p>
                                            </div>
                                        </c:if>
                                    </c:forEach>

                                    <c:forEach var="mark" items="${marks[date.id-2]}">
                                        <c:if test="${tt.teacherSubjectClass.subject.idsubject==mark.subject.idsubject}">
                                            <div class="mark">
                                            <p style="font-size: 18px; width: 10px; "><strong>${mark.mark}</strong></p>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:forEach>
                                    </div>
                            </div>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>
</t:tagStudent>

</body>
</html>
