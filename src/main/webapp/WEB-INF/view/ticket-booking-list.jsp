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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<style>
    .container .table tbody tr:hover {
        background: #eee;
    }

    .navbar {
        background: #000000;  /* fallback for old browsers */
        background: -webkit-linear-gradient(to right, #434343, #000000);  /* Chrome 10-25, Safari 5.1-6 */
        background: linear-gradient(to right, #434343, #000000); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+*/
    }
</style>
<body>
<div class="container-fluid">


    <legend><h2 class="text-info">RattlerStation: Schedules 🌐</h2></legend>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand fas fa-calendar-alt" href="#"></a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="/tickets/buyTicket"><i class="fas fa-search fa-1x"></i> Search</a></li>
                <li><a href="/home"><i class="fas fa-home fa-1x"></i> Home</a></li>
                <li><a href="/trains/selectTrainsByStation"><i class="fas fa-clock"></i> Traffic</a></li>
            </ul>
        </div>
    </nav>


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
                <td><a href="/tickets/viewTicketsTrainInfo?train=${iterated.trainName}&start=${iterated.stationDepartureName}&end=${iterated.stationArrivalName}"><i class="fas fa-shopping-cart fa-1x"></i></a></td>
            </tr>
        </c:forEach>

    </table>

</div>
</body>
</html>
