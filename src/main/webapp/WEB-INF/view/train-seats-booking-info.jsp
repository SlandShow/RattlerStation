<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Train info</title>
    <!-- Add bootstrap -->
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<style>
    table-striped tr td:hover {
        background: #eee;
    }
</style>
<body>
    <div class="container">

        <h2 class="text-info">Choose seat number:</h2>

        <!-- Add HTML table -->
        <table class="table table-striped">

            <!-- Loop over and print carriages and seats  -->
            <c:forEach var="row" items="${carriages}">
                <tr>
                    <c:forEach var="cell" items="${row}">
                        <td>
                            <a href="/tickets/confirmBooking?seat=${cell.seat}&carriage=${cell.carriage}">
                                <c:out value="${cell.seat}"/>
                            </a>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>

        </table>

    </div>
</body>
</html>
