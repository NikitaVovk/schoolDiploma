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

    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>

        <div id = "tabName">
            <p>Dane ucznia</p>
        </div>

        <div class="hr">
            <hr>
        </div>
        <div id="tabName">

        </div>
        <div id="tabNameInfo">

        </div>

        <div class="leftTable">
        <table>
            <tr>
                <th>Imie nazwisko</th>
                <td>${student.name} ${student.surname}</td>
            </tr>
            <tr>
                <th>Data urodzenia</th>
                <td>${student.dateOfBirth}</td>
            </tr>
            <tr>
                <th>Adres</th>
                <td>${student.address}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${student.email}</td>
            </tr>
            <tr>
                <th>Telefon</th>
                <td>${student.phone}</td>
            </tr>
        </table>
        </div>
    </jsp:body>
</t:tagStudent>

</body>
</html>
