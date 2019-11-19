<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 09/10/2019
  Time: 14:29
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
<p>Hello,${nameTeacher}!!!</p>
<a href="${pageContext.request.contextPath}/mainTeacher/showLesson">Zajęcia</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showMarks">Oceny</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showFrequency">Frekwencja</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showTest">Sprawdziany</a>
<a href="${pageContext.request.contextPath}/mainTeacher/showPlan">Plan zajęć</a>



<form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>
</body>
</html>
