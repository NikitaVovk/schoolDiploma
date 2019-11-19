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
</head>
<body>


<t:tagStudent>
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
                <td>Oceny</td>
                <td>Ocena śródroczna </td>
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
</div>
    </jsp:body>
</t:tagStudent>


</body>
</html>