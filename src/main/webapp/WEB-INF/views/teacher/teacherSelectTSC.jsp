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
        <table>
            <c:forEach var="listItem" items="${classSubject}" varStatus="theCount" >
                <tr>

                    <td> <a href="${pageContext.request.contextPath}/mainTeacher/${showItem}?idTSC=${listItem.id}">${listItem.aClass.name}  ${listItem.subject.name}  </a></td>
                </tr>
            </c:forEach>
        </table>
    </jsp:body>
</t:tagTeacher>


</body>
</html>
