<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 13/11/2019
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
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
            <p>Ucznie</p>
        </div>

    <div class="addStudent">

        <a href="${pageContext.request.contextPath}/mainAdmin/studentEditor">Dodaj ucznia</a>
    </div>

</div>
        <div class="hr">
            <hr>
        </div>

        <div id="tabNameInfo" style="font-size: 20px;">
            <p>Wszystkie ucznie szkoły</p>

        </div>
<div class="smallHr"><hr></div>

        <form method="get" action="${pageContext.request.contextPath}/mainAdmin/students">
            <div class="findStudent">
                <div>
            <h2 style="text-align: center;">Znajdź ucznia</h2>
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
        <div class="smallHr"><hr></div>

        <form method="get" action="${pageContext.request.contextPath}/mainAdmin/students">
            <div class="filtrClass">
                <label style="text-align: center;"><strong>Filtruj według klasy:</strong></label>
                <div class="selectorClass">

            <select id="idClass" name="idClass" onchange="location = this.value;">
                <option name="option" value="${pageContext.request.contextPath}/mainAdmin/students" selected>Wszystkie</option>
                <c:forEach var="cl" items="${classes}">
                    <c:set var="selected" value=""/>
                    <c:if test="${cl.idclass==idClass}">
                        <c:set var="selected" value="selected"/>
                    </c:if>
                    <option name="option" value="${pageContext.request.contextPath}/mainAdmin/students?idClass=${cl.idclass}" ${selected}>${cl.name}</option>
                </c:forEach>
            </select>

                </div>
            </div>
        </form>


<%--        <select id="idTSC" name="idTSC"  class="selectorClass" onchange="location = this.value;" >--%>
<%--            <option name="option" value="${pageContext.request.contextPath}/mainTeacher/showLesson" selected>-</option>--%>

<%--            <c:forEach var="aClass" items="${classList}">--%>
<%--                <c:set var="selected" value=""/>--%>
<%--                <c:if test="${aClass.id==idTSC}">--%>
<%--                    <c:set var="selected" value="selected"/>--%>
<%--                </c:if>--%>
<%--                <option name="option" value="${pageContext.request.contextPath}/mainTeacher/showLesson?idTSC=${aClass.id}" ${selected}>${aClass.subject.name} - ${aClass.aClass.name}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>


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
                <a href="${pageContext.request.contextPath}/mainAdmin/students?page=${prev}${url}" class="links2">Poprzednia strona</a>
            </div>
            <div id="pageCount" style="display: grid;justify-content: center;align-content: center;">
                <p style="text-decoration: underline;">Strona <strong>${numPage+1}</strong> z <strong>${pageCount}</strong></p>
            </div>
            <div id="next">
                <a href="${pageContext.request.contextPath}/mainAdmin/students?page=${next}${url}" class="links2">Następna strona</a>
            </div>
        </div>

        <table width="100%" border="2px solid blue">

            <tr>
                <th>№</th>
                <th>ID</th>
                <th>Nazwisko Imie</th>
                <th>Data urodzenia</th>
                <th>Klasa</th>
            </tr>
            <c:set var="licznik" value="0" />
            <c:forEach var="student" items="${studentList}">
                <c:set var="licznik" value="${licznik+1}" />

                <tr>
                    <td>${licznik}</td>
                    <td>${student.idstudent}</td>
                    <td><a href="${pageContext.request.contextPath}/mainAdmin/studentEditor?idStudent=${student.idstudent}">
                            ${student.surname} ${student.name}</a></td>
                    <td>${student.dateOfBirth}</td>
                    <td>${student.aClass.name}</td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>
</t:tagAdmin>


</body>
</html>
