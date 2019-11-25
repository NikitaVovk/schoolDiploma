<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 29/10/2019
  Time: 16:50
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
                <div class="container" id="container-footer">
                    <p id="copyright">
                        Copyright 1927, Future Bits When There Be Bits Inc.
                    </p>
                </div>
    </jsp:attribute>
    <jsp:body>

        <div id = "tabName">
            <p>Oceny</p>
        </div>

        <div class="hr">
            <hr>
        </div>

        <div id="tabNameInfo">
            <p>Twoje oceny uzyskane w tym semestrze:</p>
        </div>

        <table width="100%" border="2px solid blue">
            <tr>
                <th style="min-width: 160px;">Przedmiot</th>
                <th style="min-width: 300px;">Oceny</th>
                <th>Ocena śródroczna </th>
            </tr>
            <c:forEach var="subjectItem" items="${subjects}" >
                <tr>
                    <td>${subjectItem.name}</td>

                    <td>
                        <c:forEach var="marks" items="${marksSubject}">
                            <c:forEach var="mark" items="${marks}">
                                <c:if test="${mark.subject.idsubject==subjectItem.idsubject}">
                                    ${mark.mark}
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>
</t:tagStudent>


</body>
</html>
