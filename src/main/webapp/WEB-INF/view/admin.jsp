<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <!-- Add bootstrap -->
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<body>
        <div class="container">
            <center>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <h2>Hi, ${pageContext.request.userPrincipal.name}! ☕</h2>
                    <h3><a onclick="document.forms['logoutForm'].submit()">Logout</a></h3>
                    <br>
                    <img src="/static/images/user-login.png">
                </c:if>
                <br><br>
                <a class="btn btn-primary" href="/adminService">Manage</a>
                <br><br>
                <a class="btn btn-primary" href="/home">Back home</a>
            </center>
        </div>
</body>
</html>
