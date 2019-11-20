<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 15/10/2019
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<t:tagTeacher>
    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>
        <table width="100%" border="2px solid blue">
            <tr>
                <c:forEach var="dateItem" items="${datesLessons}">
                    <c:set var="colorDate" value="darkgreen"/>
                    <c:if test="${dateItem.equals(dateChosen)}">
                        <c:set var="colorDate" value="blue"/>
                    </c:if>

                    <td> <a style="color: ${colorDate}" href="${pageContext.request.contextPath}/mainTeacher/showLesson?idTSC=${idTSC}&date=${dateItem.getTime()}">${dateItem.toString()}</a></td>

                </c:forEach>
            </tr>

        </table>


        <form method="get" action="${pageContext.request.contextPath}/mainTeacher/showLesson" >
            <input type="hidden" name="idTSC" value="${idTSC}">
            <select id="date" name="date" >
                <c:forEach var="dateItem" items="${datesLessons}">
                    <c:set var="selected" value=""/>
                    <c:if test="${dateItem.equals(dateChosen)}">
                        <c:set var="selected" value="selected"/>
                    </c:if>
                    <option name="option" value="${dateItem.getTime()}" ${selected}>${dateItem.toString()}</option>
                </c:forEach>
            </select>

            <input type="submit" value="Submit">
        </form>

        <form method="post" action="${pageContext.request.contextPath}/mainTeacher/addLessonTheme?idTSC=${idTSC}&date=${dateChosen.getTime()}">
            <h2>Temat zajęcia</h2>
            <input type="text" name="lessonTheme"value="${lessonTheme.theme}">
            <input type="submit" value="Submit">
        </form>

        <form method="post" action="${pageContext.request.contextPath}/mainTeacher/addHomeWork?idTSC=${idTSC}&date=${dateChosen.getTime()}">
            <h2>Zadanie domowe</h2>
            <input type="text" name="homeWork"value="${homeWork.homeWork}">
            <input type="submit" value="Submit">
        </form>



        <form method="post" action="${pageContext.request.contextPath}/mainTeacher/saveProperties?idTSC=${idTSC}&date=${dateChosen.getTime()}">

            <table width="100%" border="2px solid blue">
                <tr>
                    <td>Student</td>
                    <td>Mark</td>
                </tr>
                <c:forEach var="listItem" items="${listStudents}"  >
                    <c:set var="val" value=""/>

                    <tr>
                        <td> <p>${listItem.idstudent}  ${listItem.surname} ${listItem.name} </p> </td>

                        <c:forEach var="freq" items="${freqDate}">
                            <c:choose>
                                <c:when test="${freq.student.idstudent==listItem.idstudent}">
                                    <c:set var="val" value="n"/>
                                </c:when>
                            </c:choose>
                        </c:forEach>


                        <c:forEach var="marks" items="${marksDate}">
                            <c:choose>
                                <c:when test="${marks.student.idstudent==listItem.idstudent}">
                                    <%--                                <td><p>${markListItem.mark}   ${markListItem.date.getMonth() }  ${dateItem.getTime().getMonth()}</p></td>--%>

                                    <c:set var="val" value="${marks.mark}"/>
                                </c:when>
                                <c:otherwise>

                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <td><input type="text" value="${val}" name="studentProp" width="15px"></td>

                    </tr>
                </c:forEach>

            </table>
            <input type="submit" value="Submit Form">
        </form>

        <a href="${pageContext.request.contextPath}/mainTeacher/showAll?idTSC=${idTSC}">Show All Marks</a>
        <a href="${pageContext.request.contextPath}/mainTeacher">Main page</a>
    </jsp:body>
</t:tagTeacher>


</body>
</html>









