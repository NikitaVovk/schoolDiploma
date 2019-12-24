<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 13/11/2019
  Time: 22:20
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

        <c:set var="url" value=""/>
        <c:set var="addOrEdit" value=""/>
        <c:choose>
            <c:when test="${teacher==null}">
                <c:set var="url" value="addTeacher"/>
                <c:set var="addOrEdit" value="Dodaj"/>
            </c:when>
            <c:otherwise>
                <c:set var="url" value="editTeacher?idTeacher=${teacher.idTeacher}"/>
                <c:set var="addOrEdit" value="Edytuj"/>
            </c:otherwise>
        </c:choose>
        <div style="display: grid; grid-auto-flow: column;">
        <div id = "tabName">
            <p>${addOrEdit} nauczyciela</p>
        </div>

            <c:if test="${addOrEdit.equals('Edytuj')}">
                <div class="selectClass">
                    <form method="post" action="${pageContext.request.contextPath}/mainAdmin/deleteTeacher">
                        <input type="hidden" name="idTeacher" value="${teacher.idTeacher}">
                        <input type="Submit" value="Usuń" >
                    </form>
                </div>
            </c:if>
        </div>
        <div class="hr">
            <hr>
        </div>
        <div id="tabNameInfo" style="font-size: 20px;">
            <p>Wypełnij informację</p>
        </div>

        <div class="smallHr">
            <hr>
        </div>


        <form method="post" action="${pageContext.request.contextPath}/mainAdmin/${url}">
            <div class="studentForm">
                <label><strong>Nazwisko</strong></label>
                <br>
                <input type="text" name="surname" value="${teacher.surname}" class="ltAndHm">
                <br>
                <label><strong>Imie</strong></label>
                <br>
                <input type="text" name="name" value="${teacher.name}" class="ltAndHm">
                <br>

                <label><strong>Klasa</strong></label>

                <select id="aClass" name="aClass" >
                    <option name="option" value="${null}" selected>-</option>
                    <c:forEach var="cl" items="${classes}">
                        <c:set var="selected" value=""/>
                        <c:if test="${teacher.aClass.idclass==cl.idclass}">
                            <c:set var="selected" value="selected"/>
                        </c:if>
                        <option name="option" value="${cl.idclass}" ${selected}>${cl.name}</option>

                    </c:forEach>
                </select>
                <br>
                <label><strong>Data urodzenia</strong></label>
                <input  class="ltAndHm" type="date" name="dateOfBirth" min="1945-01-01" max="2015-12-31" value="${teacher.dateOfBirth}">
                <div>
                    <hr>
                </div>
                <label><strong>Adres</strong></label>
                <br>
                <input type="text" name="address" value="${teacher.address}" class="ltAndHm">
                <br>
                <label><strong>Email</strong></label>
                <br>
                <input type="text" name="email" value="${teacher.email}" class="ltAndHm">
                <br>
                <label><strong>Telefon</strong></label>
                <br>
                <input type="text" name="phone" value="${teacher.phone}" class="ltAndHm">
                <br>


                <input type="Submit" value="Zatwierdź" style="justify-self: center; margin-top: 20px;">

            </div>
        </form>

    </jsp:body>
</t:tagAdmin>


</body>
</html>
