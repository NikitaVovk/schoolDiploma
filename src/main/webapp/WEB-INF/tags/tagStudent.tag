<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<body>
<header>
    <div id="pageHeader">
        <div class="container" id="container-header">
            <div class="png"><img  src="${pageContext.request.contextPath}/resources/images/school.png"/></div>
            <div class="gretting">
                <div class="png"><img src="${pageContext.request.contextPath}/resources/images/schoolonline.png"></div>
            </div>
    <jsp:invoke fragment="header"/>


            <div class="rightNav">
                <div class="userLogged">
                    <p>${studentJSP.name} ${studentJSP.surname}</p>
                </div>
                <div class="logOut">
                    <form action="${pageContext.request.contextPath}/logout" method="post">
                        <input type="submit" value="Sign Out" />
                    </form>
                </div>
            </div>
        </div>
        <div class="container" id="container-header2">
            <div id="witryna">
                <p><b>Witryna Ucznia</b></p>
            </div>
        </div>
    </div>
</header>

<main id="content-body">
    <div class="container" id="container-body">

        <div class="navLinks">
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/mainStudent/marks" class="links">Oceny</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/mainStudent/frequency" class="links">Frekwencja</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/mainStudent/dayBook" class="links">Dziennik</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/mainStudent/homeWork" class="links">Zadanie domowe</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/mainStudent/test" class="links">Sprawdziany</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/mainStudent/schoolAndTeachers" class="links">Szkoła i nauczyciele</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/mainStudent/data" class="links">Dane ucznia</a>
                </li>
            </ul>
        </div>

        <div class="content">
            <div class="content-wrapper">
    <jsp:doBody/>
            </div>
        </div>
    </div>
</main>
<footer id="pagefooter">
    <div class="container" id="container-footer">
        <p id="copyright">Copyright 2019, Politechnika Rzeszowska, Mykyta Vovk.</p>

        <jsp:invoke fragment="footer"/>
    </div>
</footer>
</body>
</html>