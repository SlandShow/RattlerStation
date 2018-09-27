<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: slandshow
  Date: 26.09.18
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trains info list</title>
    <!-- Define custom style -->
    <style>

        h1 {
            display: block;
            font-size: 2em;
            margin-top: 0.67em;
            margin-bottom: 0.67em;
            margin-left: 0;
            margin-right: 0;
            font-weight: bold;
            color: #5B90B0
        }

        a {
            background-color: #5b90b0;
            color: white;
            padding: 1em 1.5em;
            text-decoration: none;
            text-transform: uppercase;
        }

        a:hover {
            background-color: #555;
        }

        a:active {
            background-color: black;
        }

        a:visited {
            background-color: #ccc;
        }




        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #6fadd2;
            color: white;
        }
    </style>
</head>
<body>


<h1 class="text-info">Selected info trains 🚇</h1>
<!-- Add HTML table -->
<table id="customers">

    <tr>
        <th>Train name</th>
        <th>Station departure</th>
        <th>Station arrival</th>
        <th>Time</th>
        <th>Selected station</th>
    </tr>

    <!-- Loop over and print stations  -->
    <c:forEach var="info" items="${selectedInfoSchedules}">
        <tr>
            <td> ${info.trainName} </td>
            <td>${info.stationDepartureName}</td>
            <td>${info.stationArrivalName}</td>
            <td>${info.dateDeparture} → ${info.dateArrival}</td>
            <td>${selectedStation}</td>
        </tr>
    </c:forEach>
</table>


<br><br>
<br><br>

<center><a href="/">Back to menu</a></center>
</body>
</html>
