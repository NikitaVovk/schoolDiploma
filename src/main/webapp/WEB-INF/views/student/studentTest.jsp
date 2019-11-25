<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 12/11/2019
  Time: 21:24
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
            <p>Sprawdziany</p>
        </div>

        <div class="hr">
            <hr>
        </div>

        <div id="tabNameInfo">

        </div>
        <div id="tabWeek">
            <p>Od  ${dates.get(0).get(0).toString()} do ${dates.get(dates.size()-1).get(dates.get(dates.size()-1).size()-1).toString()}</p>
            <hr>
        </div>


        <div class="prevNext">
            <div id="prev">
                <a href="${pageContext.request.contextPath}/mainStudent/test?date=${prevWeek.getTime()}" class="links2">Poprzedni tydzien</a>
            </div>
            <div id="next">
                <a href="${pageContext.request.contextPath}/mainStudent/test?date=${nextWeek.getTime()}" class="links2">Następny tydzien</a>
            </div>
        </div>

        <div class="midTable">
        <table width="100%" border="2px solid blue" class="testClass" style="font-size: 15px;">
            <tr>
                <c:forEach var="day" items="${datesString}">
                    <th>${day.name}</th>
                </c:forEach>
            </tr>
            <c:forEach var="dateArray" items="${dates}">
                <tr>
                    <c:forEach var="date" items="${dateArray}">
                        <td>${date.toString()}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach var="date" items="${dateArray}">
                        <td class="testClass">
                            <div class="mayNull1">
                            <c:forEach var="test" items="${tests}">

                                <c:if test="${test.date.toString().equals(date.toString())}">
                                    <p><strong>${test.tsc.subject.name}</strong></p>
                                    <p><i>${test.test}</i></p>
                                </c:if>

                            </c:forEach>
                            </div>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        </div>


    </jsp:body>
</t:tagStudent>


</body>
</html>
