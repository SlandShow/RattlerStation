<!-- JSP for view schedules -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule</title>
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

    <h2 class="text-primary"><kbd>List of schedules</kbd></h2>

    <!-- Add HTML table -->
    <table class="table table-striped">

        <tr class="text-info">
            <th>Station departure</th>
            <th>Station arrival</th>
            <th>Date departure</th>
        </tr>

        <!-- Loop over and print stations  -->
        <c:forEach var="tmpSchedule" items="${selectedSchedulesByTrain}">
            <tr>
                <td>${tmpSchedule.stationDeparture.name}</td>
                <td>${tmpSchedule.stationArrival.name}</td>
                <td><small>${tmpSchedule.dateDeparture.toGMTString()} → ${tmpSchedule.dateArrival.toGMTString()}</small></td>
                <td><a class="text-light bg-dark" href="/managerToolsService/viewBookingUsersInfo/${tmpSchedule.id}">Watch</a> </td>
            </tr>
        </c:forEach>

    </table>

</div>


</body>
</html>
