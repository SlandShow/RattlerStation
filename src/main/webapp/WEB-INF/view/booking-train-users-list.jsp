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

<div class="container">

    <h2 class="text-primary"><kbd>List of all trains</kbd></h2>

    <!-- Add HTML table -->
    <table class="table table-striped">

        <tr class="text-info">
            <th>Train name</th>
            <th>Carriages count</th>
        </tr>

        <!-- Loop over and print stations  -->
        <c:forEach var="tmpTrain" items="${bookingTrains}">
        <tr>
            <td>${tmpTrain.name}</td>
            <td>${tmpTrain.carriages}</td>
            <td><a class="text-light bg-dark" href="/managerToolsService/viewSelectedSchedules/${tmpTrain.id}">Watch</a> </td>
        </tr>
        </c:forEach>

</div>
</body>
</html>
