<!-- JSP for view schedules -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule</title>
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

    <h2 class="text-primary">List of schedules</h2>

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
                <td><a class="text-light bg-dark" href="/managerToolsService/viewBookingUsersInfo/${tmpSchedule.id}"><i class="fas fa-user-cog fa-1x"></i></a></td>
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
