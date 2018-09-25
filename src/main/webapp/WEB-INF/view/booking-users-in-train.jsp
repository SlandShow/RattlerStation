<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager tools: watch all booking users</title>
    <!-- Add bootstrap -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <style>
        .container .table tbody tr:hover {
            background: #eee;
        }
    </style>
</head>
<body>
<div class="container">

    <h2 class="text-primary"><kbd>List of all booked users</kbd></h2>

    <!-- Add HTML table -->
    <table class="table table-striped">

        <tr class="text-info">
            <th>User first name</th>
            <th>User last name</th>
            <th>User login</th>
            <th>Booked seat info</th>
            <th>Stations info</th>
            <th>Train info</th>
            <th>Time info</th>
        </tr>

        <!-- Info  -->
        <c:forEach var="tmpTicket" items="${tickets}">
            <tr>
                <td>${tmpTicket.user.firstName}</td>
                <td>${tmpTicket.user.lastName}</td>
                <td class="p-3 mb-2 bg-info text-white"> ${tmpTicket.user.login}</td>
                <td><small>seat №${tmpTicket.seat.seat}, carriage №${tmpTicket.seat.carriage}</small></td>
                <td><small>${tmpTicket.schedule.stationDeparture.name} → ${tmpTicket.schedule.stationArrival.name}</small></td>
                <td><small>${tmpTicket.schedule.train.name}</small></td>
                <td><small>${tmpTicket.schedule.dateDeparture.toGMTString()} → ${tmpTicket.schedule.dateArrival.toGMTString()}</small></td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
