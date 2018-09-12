<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: slandshow
  Date: 12.09.18
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>List of Users</h2>
    </div>
</div>

<br><br>

<div class="container">

    <!-- Add HTML table -->
    <table class="table table-striped">

        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Login</th>
        </tr>

        <!-- Loop over and print stations  -->
        <c:forEach var="user" items="${users}">
            <tr>
                <td> ${user.firstName} </td>
                <td>${user.lastName}</td>
                <td>${user.login}</td>
                <td><a href="/deleteUser?id=${user.id}">Delete</a> </td>
            </tr>
        </c:forEach>

    </table>

</div>
</body>
</html>
