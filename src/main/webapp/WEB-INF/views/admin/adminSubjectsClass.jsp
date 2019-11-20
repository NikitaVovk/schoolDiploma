<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 14/11/2019
  Time: 15:36
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

        <form method="get" action="${pageContext.request.contextPath}/mainAdmin/tsc">
            <label>Klasa</label>
            <select id="idClass" name="idClass">
                <option name="option" value="${null}" selected>-</option>
                <c:forEach var="cl" items="${classes}">
                    <c:set var="selected" value=""/>
                    <c:if test="${idClass==cl.idclass}">
                        <c:set var="selected" value="selected"/>
                    </c:if>
                    <option name="option" value="${cl.idclass}" ${selected}>${cl.name}</option>
                </c:forEach>
            </select>
            <input type="Submit" value="Znajdź">
        </form>


        <c:if test="${idClass!=null}">

            <form method="post" action="${pageContext.request.contextPath}/mainAdmin/addTSC">
                <input type="hidden" name="idClass" value="${idClass}">
                <label>Przedmiot</label>
                <select id="idSubject" name="idSubject">
                    <option name="option" value="${null}" selected>-</option>
                    <c:forEach var="sub" items="${subjects}">
                        <option name="option" value="${sub.idsubject}" >${sub.name}</option>
                    </c:forEach>
                </select>
                <label>Nauczyciel</label>
                <select id="idTeacher" name="idTeacher">
                    <option name="option" value="${null}" selected>-</option>
                    <c:forEach var="teach" items="${teachers}">
                        <option name="option" value="${teach.idTeacher}" >${teach.surname} ${teach.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Dodaj">
            </form>

            <h2>Klasa ${idClass}</h2>

            <table width="100%" border="2px solid blue">
                <tr>
                    <td>Przedmiot</td>
                    <td>Nauczyciel</td>
                </tr>
                <c:forEach var="tscItem" items="${tsc}">
                    <tr>
                        <td>${tscItem.subject.name}</td>
                        <td>${tscItem.teacher.surname} ${tscItem.teacher.name}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </jsp:body>
</t:tagAdmin>


</body>
</html>
