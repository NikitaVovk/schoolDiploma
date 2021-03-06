<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 31/10/2019
  Time: 16:09
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
            <p>Informacja o szkole</p>
        </div>

        <div class="hr">
            <hr>
        </div>

        <div id="tabNameInfo">
        <h2>Szkoła</h2>
        </div>
        <div class="hr2">
            <hr>
        </div>
        <div class="leftTable">
            <table>
                <tr>
                    <th>Nazwa szkoły:</th>
                    <td><div style="min-width: 325px">IV Liceum Ogólnokształcące</div></td>
                </tr>
                <tr>
                    <th>Adres szkoły:</th>
                    <td>Swojska 6, 60-592 Poznań</td>
                </tr>
                <tr>
                    <th>Telofon:</th>
                    <td>+48 61 841 77 71</td>
                </tr>
                <tr>
                    <th>Dyrektor:</th>
                    <td>Dawid Kwiatkowski</td>
                </tr>
            </table>
        </div>
<div id="tabNameInfo">
        <h2>Nauczyciele</h2>

</div>
        <div class="hr2">
            <hr>
        </div>
<div class="midTable">
        <table width="50%" border="2px solid blue">
            <tr>
                <th>Lp.</th>
                <th>Przedmiot</th>
                <th>Nauczyciel</th>
            </tr>
            <c:set var="i" value="0"/>
            <c:forEach var="ts" items="${tsc}">
                <c:set var="i" value="${i=i+1}"/>
                <tr>
                    <td>${i}</td>
                    <td><div style="min-width: 225px">${ts.subject.name}</div></td>
                    <td><div style="min-width: 300px">${ts.teacher.surname} ${ts.teacher.name}</div></td>
                </tr>
            </c:forEach>
        </table>
</div>
    </jsp:body>
</t:tagStudent>



</body>
</html>
