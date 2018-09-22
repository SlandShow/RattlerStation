<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage trains: creation</title>
    <!-- Add bootstrap -->
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container">


        <h2>Manager: Create train</h2>

            <form:form action="createTrain" method="POST" modelAttribute="train">

            <div class="form-group col-md-6">
                <label for="inputTrainName">Train Name</label>
                <form:input type="text" path="name" class="form-control" id="inputTrainName" aria-describedby="trainNameHelp" placeholder="Enter train name"/>
            </div>

            <div class="form-group col-md-6">
                <label for="inputCarriages">Carriages</label>
                <form:input type="number" min="1" max="30" path="carriageCount" class="form-control" id="inputCarriages" placeholder="Carriages"/>
            </div>

            <div class="form-group col-md-6">
                <label for="inputSeats">Seats</label>
                <form:input type="number" min="5" path="seatsCount" class="form-control" id="inputSeats" placeholder="Seats"/>
            </div>
            <br>
            <center><button type="submit" class="btn btn-primary">Add train</button></center>
        </form:form>

        <br>
        <center>Back to <a href="#" target="blank">manager menu</center>

    </div>
</body>
</html>
