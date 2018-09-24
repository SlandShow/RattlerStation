<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager tools: watch all booking users</title>
    <!-- Add bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <!-- Add HTML table -->
    <table class="table table-striped">

        <tr>
            <th>User</th>

        </tr>

        <!-- Loop over and print stations  -->
        <c:forEach var="tmpTicket" items="${tickets}">
            <tr>
                <td>${tmpTicket.user.login} Seat #${tmpTicket.seat.seat} Carriage #${tmpTicket.seat.carriage}</td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
