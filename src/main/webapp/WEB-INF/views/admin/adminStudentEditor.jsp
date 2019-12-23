<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 13/11/2019
  Time: 15:27
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
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>

        <c:set var="url" value=""/>
        <c:set var="addOrEdit" value=""/>
        <c:choose>
            <c:when test="${student==null}">
                <c:set var="url" value="addStudent"/>
                <c:set var="addOrEdit" value="Dodaj"/>
            </c:when>
            <c:otherwise>
                <c:set var="url" value="editStudent?idStudent=${student.idstudent}"/>
                <c:set var="addOrEdit" value="Edytuj"/>
            </c:otherwise>
        </c:choose>
<div style="display: grid; grid-auto-flow: column;">
        <div id = "tabName">
            <p>${addOrEdit} ucznia</p>
        </div>
    <c:if test="${addOrEdit.equals('Edytuj')}">
    <div class="selectClass">
        <form method="post" action="${pageContext.request.contextPath}/mainAdmin/deleteStudent">
            <input type="hidden" name="idStudent" value="${student.idstudent}">
            <input type="Submit" value="Usuń ucznia" >
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
            <input type="text" name="surname" value="${student.surname}" class="ltAndHm">
                <br>
                <label><strong>Imie</strong></label>
                <br>
            <input type="text" name="name" value="${student.name}" class="ltAndHm">
                <br>

            <label><strong>Klasa</strong></label>
                <br>
            <select id="aClass" name="aClass" >
                <option name="option" value="${null}" selected>-</option>
                <c:forEach var="cl" items="${classes}">
                    <c:set var="selected" value=""/>
                    <c:if test="${student.aClass.idclass==cl.idclass}">
                        <c:set var="selected" value="selected"/>
                    </c:if>
                    <option name="option" value="${cl.idclass}" ${selected}>${cl.name}</option>

                </c:forEach>
            </select>
                <br>
            <label><strong>Data urodzenia</strong></label>
                <br>
            <input  class="ltAndHm" type="date" name="dateOfBirth" min="2000-01-01" max="2015-12-31" value="${student.dateOfBirth}">
<div>
                    <hr>
</div>
                <label><strong>Adres</strong></label>
                <br>
                <input type="text" name="address" value="${student.address}" class="ltAndHm">
                <br>
                <label><strong>Email</strong></label>
                <br>
                <input type="text" name="email" value="${student.email}" class="ltAndHm">
                <br>
                <label><strong>Telefon</strong></label>
                <br>
                <input type="text" name="phone" value="${student.phone}" class="ltAndHm">
                <br>

                <input type="Submit" value="Zatwierdź" style="justify-self: center; margin-top: 20px;">
            </div>
        </form>

    </jsp:body>
</t:tagAdmin>


</body>
</html>
