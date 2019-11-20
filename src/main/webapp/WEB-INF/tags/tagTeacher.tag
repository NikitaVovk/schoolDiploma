<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<body>
<header id="pageheader">
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Sign Out"/>
    </form>
    <p>Hello,${teacherJSP.name}!!!</p>
    <jsp:invoke fragment="header"/>
</header>
<main id="body">
    <div class="navLinks">

        <a href="${pageContext.request.contextPath}/mainTeacher/showLesson">Zajęcia</a>
        <a href="${pageContext.request.contextPath}/mainTeacher/showMarks">Oceny</a>
        <a href="${pageContext.request.contextPath}/mainTeacher/showFrequency">Frekwencja</a>
        <a href="${pageContext.request.contextPath}/mainTeacher/showTest">Sprawdziany</a>
        <a href="${pageContext.request.contextPath}/mainTeacher/showPlan">Plan zajęć</a>


    </div>
    <jsp:doBody/>



</main>
<footer id="pagefooter">
    <jsp:invoke fragment="footer"/>
</footer>
</body>
</html>