<%--
  Created by IntelliJ IDEA.
  User: vovknikita
  Date: 31/10/2019
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/student/index.css" />
</head>
<body>
<t:tagStudent>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>


<div style="display: grid; grid-auto-flow: column;">
        <div id = "tabName">
            <p>Dane ucznia</p>
        </div>

    <div class="addStudent">

        <a href="${pageContext.request.contextPath}/mainStudent/data?edit=true">Edytuj profil</a>
    </div>
</div>
        <div class="hr">
            <hr>
        </div>

        <div id="tabNameInfo">

        </div>


        <div class="midTable">
            <form method="post" action="${pageContext.request.contextPath}/mainStudent/editData">
                <div style="width: 550px;">
        <table width="100%" border="2px solid blue">
            <tr>
                <th>Imie nazwisko</th>
                <td>${student.name} ${student.surname}</td>
            </tr>
            <tr>
                <th>Data urodzenia</th>
                <td>${student.dateOfBirth}</td>
            </tr>
            <tr>
                <th>Klasa</th>
                <td>${student.aClass.name}</td>
            </tr>
            <c:choose>
                <c:when test="${edit==false}">
                    <tr>
                        <th>Adres</th>
                        <td>${student.address}</td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td>${student.email}</td>
                    </tr>
                    <tr>
                        <th>Telefon</th>
                        <td>${student.phone}</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <th>Adres</th>
                        <td><input type="text" name="address" class="dataInput" value="${student.address}"></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td>
                            <input type="text" name="email" class="dataInput" value="${student.email}"></td>
                    </tr>
                    <tr>
                        <th>Telefon</th>
                        <td><input type="text" name="phone" class="dataInput" value="${student.phone}"></td>
                    </tr>
                </c:otherwise>
            </c:choose>

        </table>
                </div>
                <c:if test="${edit==true}">
                    <div style="display: grid;justify-content: center; margin: 5px;">
                    <input type="submit" value="Zmień" >
                    </div>
                </c:if>
            </form>
        </div>
        <div class="hr2">
            <hr>
        </div>

        <c:if test="${edit==true}">

            <div class="editPasswordForm">
                <form method="post" action="${pageContext.request.contextPath}/mainStudent/changePassword">
                <div style="text-align: center; font-size: 26px; margin-bottom: 20px;"><p><strong>Zmień hasło</strong></p></div>
                <div class="enterPassword">
                    <div style="width: 150px">Aktualne hasło</div>
                    <div><input class="dataInput"  type="password" name="currentPassword"></div>
                </div>
                <div class="enterPassword">
                    <div style="width: 150px">Nowe hasło</div>
                    <div><input  class="dataInput"  type="password" name="newPassword"></div>
                </div>
                <div class="enterPassword">
                    <div style="width: 150px">Powtórz nowe hasło</div>
                    <div><input  class="dataInput" type="password" name="repeatNewPassword"></div>
                </div>

                <div style="display: grid;justify-content: center; margin: 5px;">
                    <input type="submit" value="Zmień" >
                </div>
                </form>
            </div>
        </c:if>

    </jsp:body>
</t:tagStudent>

</body>
</html>
