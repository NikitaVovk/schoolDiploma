<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 11/11/2019
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/student/index.css" />
</head>
<body>
<t:tagStudent>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div id = "tabName">
            <p>Zadania domowe</p>
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
                <a href="${pageContext.request.contextPath}/mainStudent/homeWork?date=${prevWeek.getTime()}" class="links2">Poprzedni tydzien</a>
            </div>
            <div id="next">
                <a href="${pageContext.request.contextPath}/mainStudent/homeWork?date=${nextWeek.getTime()}" class="links2">Następny tydzien</a>
            </div>
        </div>


        <table width="100%" border="2px solid blue" class="testClass2" style="font-size: 15px">
            <tr>
                <c:forEach var="day" items="${datesString}">
                    <th><p>${day.name}</p>
                          <p>${dates[day.id-2].toString()}</p></th>
                </c:forEach>
            </tr>
            <tr>
                <c:forEach var="date" items="${dates}">
                    <td>
                        <div class="mayNull">
                        <c:forEach var="hw" items="${homeWork}">
                            <c:if test="${hw.dateDue.getDate()==date.getDate()&&
           hw.dateDue.getMonth()==date.getMonth()&&
            hw.dateDue.getYear()==date.getYear()}">
                                <p><strong>${hw.tsc.subject.name}</strong></p>
                                <p><i>${hw.homeWork}</i></p>
                            </c:if>
                        </c:forEach>
                        </div>
                    </td>
                </c:forEach>
            </tr>
        </table>

    </jsp:body>
</t:tagStudent>



</body>
</html>
