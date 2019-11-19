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
</head>
<body>

<t:tag>
    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>
<div class="content">
        <table width="50%" border="2px solid blue">
            <tr>
                <c:forEach var="day" items="${datesString}">
                    <td>${day.name}</td>
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
                        <td>
                            <c:forEach var="test" items="${tests}">

                                <c:if test="${test.date.toString().equals(date.toString())}">
                                    <p><strong>${test.tsc.subject.name}</strong></p>
                                    <p>${test.test}</p>
                                </c:if>

                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/mainStudent/test?date=${prevWeek.getTime()}">Poprzedni tydzien</a>
        <a href="${pageContext.request.contextPath}/mainStudent/test?date=${nextWeek.getTime()}">Następny tydzien</a>
</div>
    </jsp:body>
</t:tag>


</body>
</html>
