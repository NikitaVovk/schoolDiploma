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
</head>
<body>
<t:tagTeacher>
    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>

        <table width="100%" border="2px solid blue">
            <tr>
                <td>Lekcja</td>
                <td>Pora lekcji</td>
                <c:forEach var="day" items="${datesString}">
                    <td>${day.name}
                            ${dates[day.id-2].toString()}</td>
                </c:forEach>
            </tr>
            <c:forEach var="lesson" items="${lessonTime}">
                <tr>
                    <td>${lesson.id}</td>
                    <td>${lesson.timeStart}
                            ${lesson.timeEnd}</td>

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
        <a href="${pageContext.request.contextPath}/mainTeacher/showPlan?date=${prevWeek.getTime()}">Poprzedni tydzien</a>
        <a href="${pageContext.request.contextPath}/mainTeacher/showPlan?date=${nextWeek.getTime()}">Następny tydzien</a>
    </jsp:body>
</t:tagTeacher>

</body>
</html>
