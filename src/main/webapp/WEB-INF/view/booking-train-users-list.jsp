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

<div class="container">

    <!-- Add HTML table -->
    <table class="table table-striped">

        <tr>
            <th>Train name</th>
        </tr>

        <!-- Loop over and print stations  -->
        <c:forEach var="tmpTrain" items="${bookingTrains}">
        <tr>
            <td>${tmpTrain.name}</td>
             <td><a href="/managerToolsService/viewSelectedSchedules/${tmpTrain.id}">Watch</a> </td>
        </tr>
        </c:forEach>

</div>
</body>
</html>
