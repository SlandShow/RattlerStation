<!-- JSP View, which list all Trains -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List Trains</title>
</head>
<body>
<!-- Add HTML table -->
<table class="table table-striped">

    <tr>
        <th>Train name</th>
        <th>Carriages</th>
        <th>Seats</th>
    </tr>

    <!-- Loop over and print stations  -->
    <c:forEach var="train" items="${trainList}">
        <tr>
            <td> ${train.name} </td>
            <td>${train.carriageCount}</td>
            <td>${train.seatsCount}</td>
            <td><a href="/deleteTrain?name=${train.name}">Delete</a> </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
