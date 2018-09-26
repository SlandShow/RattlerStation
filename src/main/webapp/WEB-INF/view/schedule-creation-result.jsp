<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule creating result</title>
    <!-- Add bootstrap -->
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2 class="text-info">Schedule creation</h2>

    <c:if test='${result.equals("success")}'>
        <h3 class="text-success">Schedule successfully created</h3>

        <div class="panel panel-success">
            <div class="panel-heading">Schedule info</div>
            <div class="panel-body"><i>${scheduleInfo.stationDepartureName}</i> → <i>${scheduleInfo.stationArrivalName}</i></div>
            <div class="panel-body"><i>${scheduleInfo.dateDeparture} → ${scheduleInfo.dateArrival}</i></div>
            <div class="panel-body">${scheduleInfo.trainName}</div>
        </div>

        <center>
            <img src="/static/images/confirm.png">
        </center>
    </c:if>
    <c:if test='${result.equals("problem")}'>
    <h3>Cannot create schedule</h3>

    <div class="alert alert-danger" role="alert">
        <strong>Can't create schedule</strong> (<i>${scheduleInfo.stationDepartureName}</i> → <i>${scheduleInfo.stationArrivalName}</i>, <i>${scheduleInfo.dateDeparture} → ${scheduleInfo.dateArrival}</i>).
        Reason is: ${reason.toLowerCase()}.
    </div>

    <br>

    <center>
        <img src="/static/images/error.jpg">
    </center>
</div>
</c:if>

<center><a href="/managerTools">Back to manager tools</a></center>

</div>
</body>
</html>
