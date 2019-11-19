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
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="100%" border="2px solid blue">
    <tr>
        <td><p>STUDENT</p></td>
        <c:forEach var="dateItem" items="${datesLessons}">
            <td width="30%"> <p>${dateItem.toString()}</p> </td>
        </c:forEach>
    </tr>

    <c:forEach var="listItem" items="${listStudents}"  >
        <tr>
            <td> <p>${listItem.idstudent}  ${listItem.surname} ${listItem.name} </p> </td>




            <c:forEach var="dateItem" items="${datesLessons}">
                <c:set var="val" value=""/>
                <c:forEach var="freqItem" items="${freqList}"  >
                    <c:forEach var="freqListItem" items="${freqItem}">
                        <c:if test="${freqListItem.student.idstudent==listItem.idstudent &&
                                                   dateItem.toString().equals(freqListItem.date.toString())}">
                            <c:set var="val" value="${freqListItem.frequency}"/>
                        </c:if>
                    </c:forEach>
                </c:forEach>

                <c:forEach var="markItem" items="${markList}"  >
                    <c:forEach var="markListItem" items="${markItem}">
                        <c:if test="${markListItem.student.idstudent==listItem.idstudent &&
                                                   dateItem.toString().equals(markListItem.date.toString())}">
                            <c:set var="val" value="${markListItem.mark}"/>
                        </c:if>
                    </c:forEach>
                </c:forEach>
<%--                <td><p>${val}</p></td>--%>
                <td width="30%"><input type="text" value="${val}" name="marks" width="15px"></td>
            </c:forEach>

        </tr>
    </c:forEach>
</table>
    <input type="submit" value="Submit Form">
</body>
</html>









