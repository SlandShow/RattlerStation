<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: slandshow
  Date: 26.09.18
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trains info list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script
    <style>
         tr td:hover {
            background: #eee;
        }
    </style>
</head>
<body>

<h1 class="text-info">Selected info trains</h1>
<!-- Add HTML table -->
<table class="table table-striped">

    <tr>
        <th>Train name</th>
        <th>Station departure</th>
        <th>Station arrival</th>
        <th>Time</th>
    </tr>

    <!-- Loop over and print stations  -->
    <c:forEach var="info" items="${selectedInfoSchedules}">
        <tr>
            <td> ${info.trainName} </td>
            <td>${info.stationDepartureName}</td>
            <td>${info.stationArrivalName}</td>
            <td>${info.dateDeparture} → ${info.dateArrival}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
