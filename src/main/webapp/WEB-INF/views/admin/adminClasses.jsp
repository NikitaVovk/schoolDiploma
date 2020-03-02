<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 13/11/2019
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/index.css" />

</head>
<body>
<t:tagAdmin>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">

    </jsp:attribute>
    <jsp:body>
        <div id = "tabName">
            <p>Klasy</p>
        </div>
        <div class="hr">
            <hr>
        </div>
        <div id="tabNameInfo" style="font-size: 20px;">
            <p>Wszystkie klasy szkoły</p>
        </div>
        <div class="smallHr">
            <hr>
        </div>

        <form method="post" action="${pageContext.request.contextPath}/mainAdmin/addClass">
            <div class="addClass">
            <h2 style="justify-self: center;">Dodaj Klasę</h2>
            <label>Nazwa:</label>
                <br>
            <input type="text" name="name" class="ltAndHm">
            <input type="Submit" value="Dodaj" class="smallSubmit" style="justify-self: center; margin: 15px;">
            </div>
        </form>

        <div class="smallHr" style="margin-bottom: 25px;">
            <hr>
        </div>
        <div class="midTable">
        <table width="100%" border="2px solid blue" style="width: 500px;">
            <c:set var="id" value="1"/>
            <tr>
                <th>ID</th>
                <th>Nazwa Klasy</th>
                <th>Usuń</th>
            </tr>
            <c:forEach var="cl" items="${classes}">
                <tr>
                    <td>${id}</td>
                    <td>${cl.name}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/mainAdmin/deleteClass">
                            <input type="hidden" name="idClass" value="${cl.idclass}">
                            <input type="Submit" value="Usuń" class="smallSubmit" style="justify-self: center;">
                        </form>
                    </td>
                </tr>
                <c:set var="id" value="${id+1}"/>
            </c:forEach>
        </table>
        </div>
    </jsp:body>
</t:tagAdmin>



</body>
</html>
