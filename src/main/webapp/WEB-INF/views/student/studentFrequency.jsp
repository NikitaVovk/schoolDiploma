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
                <td>Przedmiot</td>
                <td>Nieobecność</td>
                <td>Procent</td>
            </tr>
            <c:set var="i" value="0"/>
            <c:forEach var="subjectItem" items="${subjects}" >
                <tr>
                    <td>${subjectItem.name}</td>

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
</t:tag>

</body>
</html>
