<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 31/10/2019
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css" />
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

        <h2>Dane ucznia</h2>
        <table>
            <tr>
                <td>Imie nazwisko</td>
                <td>${student.name} ${student.surname}</td>
            </tr>
            <tr>
                <td>Data urodzenia</td>
                <td>${student.dateOfBirth}</td>
            </tr>
            <tr>
                <td>Adres</td>
                <td>${student.address}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${student.email}</td>
            </tr>
            <tr>
                <td>Telefon</td>
                <td>${student.phone}</td>
            </tr>
        </table>

    </jsp:body>
</t:tagStudent>

</body>
</html>
