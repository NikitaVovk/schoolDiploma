<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<body>
<header id="pageheader">
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Sign Out"/>
    </form>

    <jsp:invoke fragment="header"/>
</header>
<main id="body">
<div class="navLinks">
    <a href="${pageContext.request.contextPath}/mainStudent/marks">Oceny</a>
    <a href="${pageContext.request.contextPath}/mainStudent/frequency">Frekwencja</a>
    <a href="${pageContext.request.contextPath}/mainStudent/dayBook">Dziennik</a>
    <a href="${pageContext.request.contextPath}/mainStudent/homeWork">Zadanie domowe</a>
    <a href="${pageContext.request.contextPath}/mainStudent/test">Sprawdziany</a>
    <a href="${pageContext.request.contextPath}/mainStudent/schoolAndTeachers">Szkoła i nauczyciele</a>
    <a href="${pageContext.request.contextPath}/mainStudent/data">Dane ucznia</a>
</div>
    <jsp:doBody/>



</main>
<footer id="pagefooter">
    <jsp:invoke fragment="footer"/>
</footer>
</body>
</html>