<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager tools: watch all booking users</title>
    <!-- Icons -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <!-- Add bootstrap -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
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
</head>
<body>
<div class="container-fluid">

    <legend>
        <div class="fa-2x">
            <i class="fas fa-cog fa-spin"></i>
            <i class="text fa-1x">RattlerStation: manager tools</i>
            <i class="fas fa-cog fa-spin"></i>
        </div>
    </legend>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand fas fa-wrench" href="/managerTools"></a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="/home">Home</a></li>
            </ul>
        </div>
    </nav>

    <h2 class="text-primary">List of all booked users</h2>

    <!-- Add HTML table -->
    <table class="table table-striped">

        <tr class="text-info">
            <th>First name</th>
            <th>Last name</th>
            <th>Login</th>
            <th>Seat info</th>
            <th>Stations</th>
            <th>Train</th>
            <th>Time</th>
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

    <br><br><br><br>

    <!-- Footer -->
    <footer class="page-footer font-small black">

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">© 2018 Copyright:
            <a href="/home"> JavaSchool 27 RattlerStation</a>
        </div>
        <!-- Copyright -->

    </footer>
    <!-- Footer -->

</div>
</body>
</html>
