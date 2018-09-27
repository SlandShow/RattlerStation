<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rattler Station</title>
    <!-- Define custom styles here -->
    <style>
        body {
            font-family: "Helvetica", sans-serif;
        }

        #header {
            color: #5b90b0;
        }

        .sidenav {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #6fadd2;
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }

        .sidenav a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            font-size: 25px;
            color: rgb(0, 0, 0);
            display: block;
            transition: 0.3s;
        }

        .sidenav a:hover {
            color: #f1f1f1;
        }

        .sidenav .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
        }

        #main {
            transition: margin-left .5s;
            padding: 16px;
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }
    </style>
</head>
<body>

        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="/trains/selectTrainsByStation">Traffic info</a>
            <a href="/tickets/buyTicket">Book ticket</a>
            <a href="#">Contact us</a>
            <a href="/login">Log in</a>

            <!-- Manager tools -->
            <sec:authorize access="hasRole('ROLE_MANAGER')">
                <a  href="/managerTools">Manager tools</a>
            </sec:authorize>

            <!-- Admin tools -->
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a  href="/admin">Admin tools</a>
            </sec:authorize>
        </div>

        <div id="main">
            <div id="header">
                <h1>Rattler station 🚄</h1>
            </div>

            <p>Our service allows you to view the train schedule for the station, search for the required train via the selected data, book tickets. We hope that our application will help you 🌟</p>
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span>
        </div>

        <script>
            function openNav() {
                document.getElementById("mySidenav").style.width = "250px";
                document.getElementById("main").style.marginLeft = "250px";
            }

            function closeNav() {
                document.getElementById("mySidenav").style.width = "0";
                document.getElementById("main").style.marginLeft= "0";
            }
        </script>

</body>
</html>
