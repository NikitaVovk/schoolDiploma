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

        <br>

        <c:if test="${numPage>0}">
            <c:set value="${numPage-1}" var="prev"/>
        </c:if>
        <c:if test="${numPage<pageCount-1}">
            <c:set value="${numPage+1}" var="next"/>
        </c:if>
        <c:if test="${numPage==pageCount-1}">
            <c:set value="${numPage}" var="next"/>
        </c:if>



        <div class="prevNext">
            <div id="prev">
                <a href="${pageContext.request.contextPath}/mainAdmin/teachers?page=${prev}${url}" class="links2">Poprzednia strona</a>
            </div>
            <div id="pageCount" style="display: grid;justify-content: center;align-content: center;">
                <p style="text-decoration: underline;">Strona <strong>${numPage+1}</strong> z <strong>${pageCount}</strong></p>
            </div>
            <div id="next">
                <a href="${pageContext.request.contextPath}/mainAdmin/teachers?page=${next}${url}" class="links2">Następna strona</a>
            </div>
        </div>


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
