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
                    <p>${teacherJSP.name} ${teacherJSP.surname}</p>
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
                <p><b>Witryna Nauczyciela</b></p>
            </div>
        </div>
    </div>

</header>
<main id="content-body">
    <div class="container" id="container-body">
        <c:set var="linkIdTSC" value=""/>
        <c:if test="${idTSC!=null}">
            <c:set var="linkIdTSC" value="?idTSC=${idTSC}"/>

        </c:if>

    <div class="navLinks">
        <ul>
            <li>
            <a href="${pageContext.request.contextPath}/mainTeacher/showLesson${linkIdTSC}"class="links">Zajęcia</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/mainTeacher/showMarks${linkIdTSC}"class="links">Oceny</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/mainTeacher/showFrequency${linkIdTSC}"class="links">Frekwencja</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/mainTeacher/showTest${linkIdTSC}" class="links">Sprawdziany</a>
        </li>
            <li>
                <a href="${pageContext.request.contextPath}/mainTeacher/showPlan${linkIdTSC}" class="links">Plan zajęć</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/mainTeacher/school" class="links">Moja szkoła</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/mainTeacher/data" class="links">Dane nauczyciela</a>
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