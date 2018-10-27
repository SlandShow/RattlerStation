<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy ticket</title>
    <!-- Add icons -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <!-- Add bootstrap -->
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.min.js"></script>

    <style>
        .navbar {
            background: #000000;  /* fallback for old browsers */
            background: -webkit-linear-gradient(to right, #434343, #000000);  /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to right, #434343, #000000); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+*/
        }
    </style>
</head>
<body>
    <div class="container-fluid">

        <legend><h1>RattlerStation 🌐</h1></legend>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand fas fa-dollar-sign" href="#"></a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="/tickets/buyTicket"><i class="fas fa-search fa-1x"></i> Search</a></li>
                    <li><a href="/home"><i class="fas fa-home fa-1x"></i> Home</a></li>
                    <li><a href="/trains/selectTrainsByStation"><i class="fas fa-clock"></i> Traffic</a></li>
                </ul>
            </div>
        </nav>


        <h2 class="text-info">Booking ticket <i class="fas fa-money-check-alt"></i></h2>

        <!-- Chose result image -->
        <c:if test='${message.equals("success")}'>
            <h3 class="text-success">Our congratulations! Your ticket is booked</h3>

            <div class="panel panel-success">
                <div class="panel-heading">Ticket info</div>
                <div class="panel-body">Seat: <kbd>${ticketInfo.seatNumber}</kbd></div>
                <div class="panel-body">Carriage: <kbd>${ticketInfo.carriageNumber}</kbd></div>
                <div class="panel-body">Mail: <kbd>${ticketInfo.user}</kbd></div>
                <div class="panel-body"><i>${ticketInfo.stationDepartureName} → ${ticketInfo.stationArrivalName}</i></div>
                <div class="panel-body"><i>${ticketInfo.dateDeparture.toGMTString()} → ${ticketInfo.dateArrival.toGMTString()}</i></div>
                <div class="panel-body">Price: <kbd>${ticketInfo.price}</kbd></div>
            </div>

            <center>
             <img src="/static/images/confirm.png">
            </center>
        </c:if>
        <c:if test='${message.equals("problem")}'>
                <h3>Cannot booked ${ticketInfo.user} :(</h3>

                    <div class="alert alert-danger" role="alert">
                        <strong>We have some problems with booking seat</strong> (<kbd>carriage №${ticketInfo.carriageNumber}</kbd>, <kbd>seat №${ticketInfo.seatNumber}</kbd>).
                        Reason is: <strong>${reason.toLowerCase()}.</strong>
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
