<!-- JSP for view schedules -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule</title>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Schedule</h2>
    </div>
</div>


<div class="container">

    <!-- Add HTML table -->
    <table class="table table-striped">

        <tr>
            <th>Station departure</th>
            <th>Station arrival</th>
            <th>Date departure</th>
        </tr>

        <!-- Loop over and print stations  -->
        <c:forEach var="tmpSchedule" items="${schedules}">
            <tr>
                <td>${tmpSchedule.stationDeparture}</td>
                <td>${tmpSchedule.stationArrival}</td>
                <td>${tmpSchedule.dateDeparture}/></td>
            </tr>
        </c:forEach>

    </table>

</div>


</body>
</html>
