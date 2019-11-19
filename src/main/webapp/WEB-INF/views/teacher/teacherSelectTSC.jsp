<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 12/11/2019
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/mainTeacher/showLesson">Zajęcia</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showMarks">Oceny</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showFrequency">Frekwencja</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showTest">Sprawdziany</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showPlan">Plan zajęć</a>
<table>
    <c:forEach var="listItem" items="${classSubject}" varStatus="theCount" >
        <tr>

            <td> <a href="${pageContext.request.contextPath}/mainTeacher/${showItem}?idTSC=${listItem.id}">${listItem.aClass.name}  ${listItem.subject.name}  </a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
