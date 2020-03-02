<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 07/11/2019
  Time: 13:28
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
            <p>Frekwencja</p>
        </div>

        <div class="hr">
            <hr>
        </div>

        <div id="tabNameInfo">
            <p>Twoja frekwencja uzyskana w tym semestrze:</p>
        </div>
<div class="midTable">

        <table width="100%" border="2px solid blue">
            <tr>
                <th>Przedmiot</th>
                <th>Nieobecności</th>
                <th>Procent obecności, %</th>
            </tr>
            <c:set var="i" value="0"/>
            <c:forEach var="subjectItem" items="${subjects}" >
                <tr>
                    <td><div style="min-width: 300px">${subjectItem.name}</div></td>

                    <td>

                            ${freqSubject[i].size()}



                            <%--                <c:forEach var="frequency" items="${freqSubject}">--%>
                            <%--                    <c:forEach var="freq" items="${frequency}">--%>
                            <%--                        <c:if test="${freq.subject.idsubject==subjectItem.idsubject}">--%>
                            <%--                            ${freq.frequency}--%>
                            <%--                        </c:if>--%>
                            <%--                    </c:forEach>--%>
                            <%--                </c:forEach>--%>
                    </td>
                    <td>
                            ${String.format("%.2f", percents[i])}
                        <c:set var="i" value="${i=i+1}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
</div>
    </jsp:body>
</t:tagStudent>

</body>
</html>
