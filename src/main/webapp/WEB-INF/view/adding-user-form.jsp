<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: slandshow
  Date: 11.09.18
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding User</title>
</head>
<body>
<div>
    <form:form action="addUser" method="POST" modelAttribute="user">
        First name:
        <<form:input type="text" path="firstName" id="firstName"/>
        <br><br>
        Last name:
        <<form:input type="text" path="lastName" id="lastName"/>
        <br><br>
        Login:
        <<form:input type="text" path="login" id="login"/>
        <br><br>
        Password:
        <<form:input type="text" path="password" id="password"/>
        <br><br>
        Role:
        <br><br>
        <input type="radio" name="role" value="USER_ROLE" checked> User<br>
        <input type="radio" name="role" value="ADMIN_ROLE"> Admin<br>
        <input type="radio" name="role" value="MANAGER_ROLE"> Manager<br>

        <input type="submit" value="Add"/>
    </form:form>
</div>
</body>
</html>
