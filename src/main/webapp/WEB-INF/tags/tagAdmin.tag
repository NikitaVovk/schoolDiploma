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

        <a href="${pageContext.request.contextPath}/mainAdmin/students">Uczni</a>
        <a href="${pageContext.request.contextPath}/mainAdmin/teachers">Nauczyciele</a>
        <a href="${pageContext.request.contextPath}/mainAdmin/classes">Klasy</a>
        <a href="${pageContext.request.contextPath}/mainAdmin/subjects">Przedmioty</a>
        <a href="${pageContext.request.contextPath}/mainAdmin/tsc">Zajęcia Klasy</a>
        <a href="${pageContext.request.contextPath}/mainAdmin/plan">Plan Zajęć</a>

    </div>
    <div class="content">
    <jsp:doBody/>
    </div>


</main>
<footer id="pagefooter">
    <jsp:invoke fragment="footer"/>
</footer>
</body>
</html>