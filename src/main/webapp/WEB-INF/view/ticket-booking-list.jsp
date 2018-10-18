<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: slandshow
  Date: 09.09.18
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking tickets</title>
    <!-- Add bootstrap -->
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<style>
    .container .table tbody tr:hover {
        background: #eee;
    }
</style>
<body>
<div class="container">


    <h2 class="text-info">Schedules list</h2>


    <!-- Add HTML table -->
    <table class="table table-striped">

        <tr class="text-info">
            <th>Stations</th>
            <th>Date departure</th>
            <th>Date arrival</th>
            <th>Train name</th>
        </tr>

        <!-- Loop over and print stations  -->
        <c:forEach var="iterated" items="${schedules}">
            <tr>
                <td>${iterated.stationDepartureName} → ${iterated.stationArrivalName}</td>
                <td><small>${iterated.dateDeparture.substring(0, 19)}</small></td>
                <td><small>${iterated.dateArrival.substring(0, 19)}</small></td>
                <td>${iterated.trainName}</td>
                <td><a href="/tickets/viewTicketsTrainInfo?train=${iterated.trainName}&start=${iterated.stationDepartureName}&end=${iterated.stationArrivalName}">Buy</a> </td>
            </tr>
        </c:forEach>

    </table>

</div>
</body>
</html>
