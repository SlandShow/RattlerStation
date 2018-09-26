<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy ticket</title>
    <!-- Add bootstrap -->
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">

        <h2 class="text-info">Booking ticket</h2>

        <!-- Chose result image -->
        <c:if test='${message.equals("success")}'>
            <h3 class="text-success">Our congratulations! Your ticket is booked</h3>

            <div class="panel panel-success">
                <div class="panel-heading">Ticket info</div>
                <div class="panel-body"><kbd>${ticketInfo.seatNumber}</kbd></div>
                <div class="panel-body"><kbd>${ticketInfo.carriageNumber}</kbd></div>
                <div class="panel-body"><kbd>${ticketInfo.user}</kbd></div>
                <div class="panel-body"><i>${ticketInfo.stationDepartureName} → ${ticketInfo.stationArrivalName}</i></div>
                <div class="panel-body"> <i>${ticketInfo.dateDeparture.toGMTString()} → ${ticketInfo.dateArrival.toGMTString()}</i></div>
            </div>

            <center>
             <img src="/static/images/confirm.png">
            </center>
        </c:if>
        <c:if test='${message.equals("problem")}'>
                <h3>Cannot booked ${ticketInfo.user} :(</h3>

                    <div class="alert alert-danger" role="alert">
                        <strong>We have some problems with booking seat</strong> (<kbd>carriage №${ticketInfo.carriageNumber}</kbd>, <kbd>seat №${ticketInfo.seatNumber}</kbd>).
                        Reason is: <strong>${reason.toLowerCase()}.<strong>
                    </div>

                    <br>

                    <center>
                        <img src="/static/images/error.jpg">
                    </center>
                </div>
        </c:if>

    </div>
</body>
</html>
