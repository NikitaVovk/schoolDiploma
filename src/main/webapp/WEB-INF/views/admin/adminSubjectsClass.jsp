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
                <p>Zajęcia</p>
            </div>
            <div class="selectClass">
                <div style="display: grid;justify-content: center;align-content: center; margin-bottom: 3px; font-size: 13px;"><p>Wybierz klasę</p></div>
                <select id="idClass" name="idClass"  class="selectorClass" onchange="location = this.value;" >
                    <option name="option" value="${pageContext.request.contextPath}/mainAdmin/tsc" selected>-</option>

                    <c:forEach var="oneClass" items="${classes}">
                        <c:set var="selected" value=""/>
                        <c:if test="${oneClass.idclass==classId}">
                            <c:set var="selected" value="selected"/>
                        </c:if>
                        <option name="option" value="${pageContext.request.contextPath}/mainAdmin/tsc?idClass=${oneClass.idclass}" ${selected}>${oneClass.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="hr">
            <hr>
        </div>
        <div id="tabNameInfo" style="font-size: 20px;">
            <p>Zajęcia klasy <strong>${aClass.name}</strong></p>
        </div>

        <div class="smallHr">
            <hr>
        </div>

<%--        <form method="get" action="${pageContext.request.contextPath}/mainAdmin/tsc">--%>
<%--            <label>Klasa</label>--%>
<%--            <select id="idClass" name="idClass">--%>
<%--                <option name="option" value="${null}" selected>-</option>--%>
<%--                <c:set var="selected" value=""/>--%>
<%--                <c:forEach var="cl" items="${classes}">--%>

<%--                    <c:if test="${aClass.idclass==cl.idclass}">--%>
<%--                        <c:set var="selected" value="selected"/>--%>
<%--                    </c:if>--%>
<%--                    <option name="option" value="${cl.idclass}" ${selected}>${cl.name}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--            <input type="Submit" value="Znajdź">--%>
<%--        </form>--%>


        <c:if test="${classId!=null}">

            <form method="post" action="${pageContext.request.contextPath}/mainAdmin/addTSC">
                <div class="addTSC">
                    <p style="margin-bottom: 15px"><STRONG>Dodaj Zajęcie</STRONG></p>
                <input type="hidden" name="idClass" value="${classId}">
                    <div class="teacherSubject">
                    <div class="subject">
                <label>Przedmiot</label>
                <br>
                <select id="idSubject" name="idSubject">
                    <option name="option" value="${null}" selected>-</option>
                    <c:forEach var="sub" items="${subjects}">
                        <option name="option" value="${sub.idsubject}" >${sub.name}</option>
                    </c:forEach>
                </select>
                    </div>

                    <div class="teacher">
                <label>Nauczyciel</label>
                    <br>
                <select id="idTeacher" name="idTeacher">
                    <option name="option" value="${null}" selected>-</option>
                    <c:forEach var="teach" items="${teachers}">
                        <option name="option" value="${teach.idTeacher}" >${teach.surname} ${teach.name}</option>
                    </c:forEach>
                </select>
                    </div>
                    </div>
                <input type="submit" value="Dodaj" class="smallSubmit" style="justify-self: center;margin-top: 30px;">
                </div>
            </form>
            <div class="smallHr" style="margin-bottom: 40px;">
                <hr>
            </div>



            <table width="100%" border="2px solid blue">
                <tr>
                    <th>№</th>
                    <th>Przedmiot</th>
                    <th>Nauczyciel</th>
                    <th>Usuń</th>
                </tr>
                <c:set var="licznik" value="0"/>
                <c:forEach var="tscItem" items="${tsc}">
                    <c:set var="licznik" value="${licznik+1}"/>
                    <tr>
                        <td>${licznik}</td>
                        <td>${tscItem.subject.name}</td>
                        <td>${tscItem.teacher.surname} ${tscItem.teacher.name}</td>
                        <td>
                            <form method="post" action="${pageContext.request.contextPath}/mainAdmin/deleteTSC">
                                <input type="hidden" name="idTSC" value="${tscItem.id}">
                                <input type="Submit" value="Usuń" class="smallSubmit" style="justify-self: center;">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </jsp:body>
</t:tagAdmin>


</body>
</html>
