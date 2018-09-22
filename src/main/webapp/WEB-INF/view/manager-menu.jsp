<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager menu</title>
    <!-- Add bootstrap (NOT LOCAL!) -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Manager tools</h2>
<div class="container-fluid">

    <ul class="nav navbar-nav">
        <li><a href="/createTrain">Create train</a></li>
        <li><a href="/deleteTrain">Delete train</a></li>
        <li><a href="/stations/createStation">Create station</a></li>
        <li><a href="/schedule/createSchedule">Create schedule</a></li>
    </ul>

</div>
</body>
</html>
