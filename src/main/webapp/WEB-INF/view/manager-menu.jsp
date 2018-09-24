<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager menu</title>
    <!-- Add bootstrap (NOT LOCAL!) -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.1/moment.min.js"></script>

    <!-- Add CSS for top bar -->
    <style>
        html, body {
            margin: 0;
            padding: 0;
        }
        .top-bar {
            display: block;
            width: 100%;
            height: 50px;
            background: #6FADD2;
            box-shadow: 0 0 4px 2px rgba(0,0,0,.4);
        }
        .top-bar ul li a {
            display: block;
            height: 50px;
            color: #fff;
        }
        .top-bar ul li a:focus, .top-bar ul li a:hover {
            background: #5b9bc1;
        }
    </style>
</head>
<body>

<div class="container-fluid top-bar">
    <ul class="nav navbar-nav">
        <li><a href="/trains/createTrain">Create train</a></li>
        <li><a href="/deleteTrain">Delete train</a></li>
        <li><a href="/stations/createStation">Create station</a></li>
        <li><a href="/schedule/createSchedule">Create schedule</a></li>
        <li><a href="/managerToolsService/viewBookingTrains">Watch all booking users</a></li>
    </ul>
</div>

<h2>Manager tools</h2>

</div>
</body>
</html>
