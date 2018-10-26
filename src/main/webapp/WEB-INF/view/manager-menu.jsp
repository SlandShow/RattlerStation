<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager menu</title>
    <!-- Add bootstrap -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">


    <!-- Add CSS for top bar -->
    <style>
        @import url("https://fonts.googleapis.com/css?family=Varela+Round");
        html {
            box-sizing: border-box;
        }

        *,
        *:before,
        *:after {
            box-sizing: inherit;
            padding: 0;
            margin: 0;
            letter-spacing: 1.1px;
        }

        body,
        html {
            width: 100%;
            height: 100%;
            background: rgba(97, 144, 232, 0.82);  /* fallback for old browsers */
            background: -webkit-linear-gradient(to right, #A7BFE8, #6190e8);  /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to right, #A7BFE8, #6190e8); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            font-family: "Helvetica", sans-serif;
        }

        .menu {
            display: flex;
            justify-content: center;
            align-items: center;
            max-width: 720px;
            margin: 0 auto;
            height: 100vh;
            list-style: none;
        }

        .menu li {
            width: 140px;
            height: 50px;
            transition: background-position-x 0.9s linear;
            text-align: center;

        a {
            font-size: 32px;
            color: White;
            text-decoration: none;
            transition: all 0.45s;
        }

        &:hover {
             background: url("data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KPHN2ZyB2ZXJzaW9uPSIxLjEi%0D%0AIGlkPSJMYXllcl8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhs%0D%0AaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCIKCSB3aWR0%0D%0AaD0iMzkwcHgiIGhlaWdodD0iNTBweCIgdmlld0JveD0iMCAwIDM5MCA1MCIgZW5hYmxlLWJhY2tn%0D%0Acm91bmQ9Im5ldyAwIDAgMzkwIDUwIiB4bWw6c3BhY2U9InByZXNlcnZlIj4KPHBhdGggZmlsbD0i%0D%0Abm9uZSIgc3Ryb2tlPSIjZDk0ZjVjIiBzdHJva2Utd2lkdGg9IjEuNSIgc3Ryb2tlLW1pdGVybGlt%0D%0AaXQ9IjEwIiBkPSJNMCw0Ny41ODVjMCwwLDk3LjUsMCwxMzAsMAoJYzEzLjc1LDAsMjguNzQtMzgu%0D%0ANzc4LDQ2LjE2OC0xOS40MTZDMTkyLjY2OSw0Ni41LDI0My42MDMsNDcuNTg1LDI2MCw0Ny41ODVj%0D%0AMzEuODIxLDAsMTMwLDAsMTMwLDAiLz4KPC9zdmc+Cg==");
             animation: line 1s;
         }

        &:hover a {
             color: #d94f5c;
         }

        &:not(:last-child) {
             margin-right: 30px;
         }
        }

        @keyframes line {
            0% {
                background-position-x: 390px;
            }
        }

    </style>
</head>
<body>
<center>

        <h1>
            Manager tools menu
        </h1>

</center>


<nav>
    <ul class="menu">
        <li><a href="/trains/createTrain"><i class="fas fa-train fa-3x"></i></a></li>
        <li><a href="/stations/createStation"><i class="fas fa-store-alt fa-3x"></i></a></li>
        <li><a href="/schedule/createSchedule"><i class="fas fa-calendar-alt fa-3x"></i></a></li>
        <li><a href="/managerToolsService/viewBookingTrains"><i class="fas fa-user-cog fa-3x"></i></a></li>
        <li><a href="/home"><i class="fas fa-home fa-3x"></i></a></li>
    </ul>
</nav>
</body>
</html>
