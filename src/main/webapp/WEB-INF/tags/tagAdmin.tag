<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <p>Admin</p>
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
                <p><b>Witryna Admina</b></p>
            </div>
        </div>
    </div>
</header>
<main id="content-body">
    <div class="container" id="container-body">
    <div class="navLinks">
        <c:set var="linkClassID" value=""/>
        <c:if test="${classId!=null}">
            <c:set var="linkClassID" value="?idClass=${classId}"/>

        </c:if>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/mainAdmin/students" class="links">Ucznie</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/mainAdmin/teachers" class="links">Nauczyciele</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/mainAdmin/classes" class="links">Klasy</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/mainAdmin/subjects" class="links">Przedmioty</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/mainAdmin/tsc${linkClassID}" class="links">Zajęcia</a>
            </li>

            <li>
                <a href="${pageContext.request.contextPath}/mainAdmin/plan${linkClassID}" class="links">Plan zajęć</a>
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
    <jsp:invoke fragment="footer"/>
</footer>
</body>
</html>