<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 29/10/2019
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css" />
</head>
<body>

<t:tagStudent>
    <jsp:attribute name="header">
                          <div class="gretting">
                              <div><h1>Welcome</h1></div>
                          </div>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>

    </jsp:body>
</t:tagStudent>



</body>
</html>
