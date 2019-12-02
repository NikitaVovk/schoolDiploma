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
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>

        <div style="display: grid; grid-auto-flow: column;">
            <div id = "tabName">
                <p>Nauczyciele</p>
            </div>

            <div class="addStudent">

                <a href="${pageContext.request.contextPath}/mainAdmin/teacherEditor">Dodaj nauczyciela</a>
            </div>

        </div>
        <div class="hr">
            <hr>
        </div>

        <div id="tabNameInfo" style="font-size: 20px;">
            <p>Wszystkie nauczyciele szkoły</p>

        </div>
        <div class="smallHr"><hr></div>

        <form method="get" action="${pageContext.request.contextPath}/mainAdmin/teachers">



            <div class="findStudent" style="margin-bottom: 35px;">
                <div>
                    <h2 style="text-align: center;">Znajdź nauczyciela</h2>
                </div>
                <div id="searchStudent">
                    <div id="surName">
                        <label>Nazwisko</label>
                        <br>
                        <input type="text" name="surname" class="ltAndHm">
                    </div>
                    <div id="name">
                        <label>Imie</label>
                        <br>
                        <input type="text" name="name" class="ltAndHm">
                    </div>
                    <br>

                </div>
                <input  class="smallSubmit" type="Submit" value="Znajdź" style="justify-self: center;">
            </div>
        </form>

        <table width="100%" border="2px solid blue">

            <tr>
                <th>№</th>
                <th>ID</th>
                <th>Nazwisko Imie</th>
                <th>Data urodzenia</th>
                <th>Klasa Wychowawcy</th>
            </tr>
            <c:set var="licznik" value="0"/>
            <c:forEach var="teacher" items="${teacherList}">
                <c:set var="licznik" value="${licznik+1}"/>

                <tr>
                    <td>${licznik}</td>
                    <td>${teacher.idTeacher}</td>
                    <td><a href="${pageContext.request.contextPath}/mainAdmin/teacherEditor?idTeacher=${teacher.idTeacher}">
                            ${teacher.surname} ${teacher.name}</a></td>
                    <td>${teacher.dateOfBirth}</td>
                    <td>${teacher.aClass.name}</td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>
</t:tagAdmin>


</body>
</html>
