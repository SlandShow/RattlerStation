<!-- Menu -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rattler Station</title>
    <!-- Add bootstrap (NOT LOCAL!) -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h2>Rattler Station</h2>

    <div class="container-fluid">

        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="/schedule/scheduleList">Schedule</a></li>
            <li><a href="/schedule/scheduleByStationsAndDate">Actual train traffic</a></li>
            <li><a href="#">Buy ticket</a></li>
            <li><a href="/stations/list">Show all stations</a></li>
            <li><a href="#">Contact us</a></li>
            <li><a href="/login">Log in</a></li>
        </ul>

    </div>

</body>
</html>
