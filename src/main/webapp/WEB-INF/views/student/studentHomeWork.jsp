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
        <table width="100%" border="2px solid blue">
            <tr>
                <c:forEach var="day" items="${datesString}">
                    <td>${day.name}
                            ${dates[day.id-2].toString()}</td>
                </c:forEach>
            </tr>
            <tr>
                <c:forEach var="date" items="${dates}">
                    <td>
                        <c:forEach var="hw" items="${homeWork}">
                            <c:if test="${hw.dateDue.getDate()==date.getDate()&&
           hw.dateDue.getMonth()==date.getMonth()&&
            hw.dateDue.getYear()==date.getYear()}">
                                <p><strong>${hw.tsc.subject.name}</strong></p>
                                <p>${hw.homeWork}</p>
                            </c:if>
                        </c:forEach>
                    </td>
                </c:forEach>
            </tr>
        </table>
        <a href="${pageContext.request.contextPath}/mainStudent/homeWork?date=${prevWeek.getTime()}">Poprzedni tydzien</a>
        <a href="${pageContext.request.contextPath}/mainStudent/homeWork?date=${nextWeek.getTime()}">Następny tydzien</a>
</div>
    </jsp:body>
</t:tag>



</body>
</html>
