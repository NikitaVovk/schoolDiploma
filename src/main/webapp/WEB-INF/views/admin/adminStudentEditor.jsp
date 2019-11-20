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
</head>
<body>
<t:tagAdmin>
    <jsp:attribute name="header">
      <h1>Welcome</h1>
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

        <form method="post" action="${pageContext.request.contextPath}/mainAdmin/${url}">
            <h2>${addOrEdit} ucznia</h2>
            <label>Nazwisko</label>
            <input type="text" name="surname" value="${student.surname}">
            <label>Imie</label>
            <input type="text" name="name" value="${student.name}">
            <label>Klasa</label>

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
            <label>Data urodzenia</label>
            <input type="date" name="dateOfBirth" min="2000-01-01" max="2015-12-31" value="${student.dateOfBirth}">
            <input type="Submit" value="Zatwierdź">
        </form>

    </jsp:body>
</t:tagAdmin>


</body>
</html>
