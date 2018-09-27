<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Service Manager</title>
    <!-- Add bootstrap (NOT LOCAL!) -->
    <!-- Add bootstrap -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>

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
            background: rgba(221, 80, 7, 0.79);
            box-shadow: 0 0 4px 2px rgba(0,0,0,.4);
        }
        .top-bar ul li a {
            display: block;
            height: 50px;
            color: #fff;
        }
        .top-bar ul li a:focus, .top-bar ul li a:hover {
            background: rgba(222, 78, 7, 0.89);
        }
    </style>
</head>
<body>

    <div class="container-fluid top-bar">
        <ul class="nav navbar-nav">
            <li><a href="/addUser">Add user</a></li>
            <li><a href="/deleteUser">Delete user</a></li>
            <li><a href="/home">Home</a></li>
        </ul>
    </div>

    <center>
        <h2>Admin tools ⌚</h2>
    </center>

    <br><br>

    <center>
        <img src="/static/images/admin-tools4.jpg">
    </center>

</body>
</html>
