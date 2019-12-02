<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<body>
<header>
    <div id="pageHeader">
        <div class="container" id="container-header">
            <div class="png"><img  src="./resources/images/school.png"/></div>
            <div class="gretting">
                <div class="png"><img src="./resources/images/schoolonline.png"></div>
            </div>
            <jsp:invoke fragment="header"/>


            <div class="rightNav">
                <div class="userLogged">
                    <p>Załoguj się</p>
                </div>

            </div>




        </div>
    </div>
</header>

<main id="content-body">
    <div class="container" id="container-body">



                <jsp:doBody/>

    </div>
</main>
<footer id="pagefooter">
    <div class="container" id="container-footer">
        <jsp:invoke fragment="footer"/>
    </div>
</footer>
</body>
</html>