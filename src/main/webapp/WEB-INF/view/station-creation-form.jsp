<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager tools: station creation</title>
    <script type="text/javascript" src="/static/js/jquery-1.11.2.js"></script>
    <script type="text/javascript" src="/static/js/jcanvas.js"></script>
    <link type="text/css" rel="stylesheet" href="/static/css/schedule-map.css" />
    <!-- Add bootstrap and datepicker -->
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/moment.min.js"></script>
    <link rel="stylesheet"
          href="/static/css/bootstrap-datetimepicker.min.css">
    <script src="/static/js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>

<div class="container" style="display: block;">
<!-- Container starts -->

    <form:form action="createStation" method="POST" modelAttribute="stationCreation" accept-charset="UTF-8">

        <legend>Create station</legend>

        <div class="row" style="width: 500px;display: block;margin: 0 auto;">
            <div class='col-sm-0'>
                <div class="form-group">
                    <div class="input-group">
                        <!-- Input starts -->

                        <!-- Train name -->
                        <div class="row">
                            <div class='col-sm-12'>
                                <div class="form-group">
                                    <div class="input-group">
                                        <form:input type="text" path="name" id="name" class="form-control" placeholder="Station name"/>
                                    </div>
                                </div>
                                <div>

                                    <!-- Station longitude -->
                                    <div class="row">
                                        <div class='col-sm-12'>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <form:input type="number" step="0.000001" path="latitude" id="latitude" class="form-control" placeholder="Station longitude"/>
                                                </div>
                                            </div>
                                            <div>

                                                <!-- Station latitude -->
                                                <div class="row">
                                                    <div class='col-sm-12'>
                                                        <div class="form-group">
                                                            <div class="input-group">
                                                                <form:input type="number" step="0.000001" path="longitude" id="longitude" class="form-control" placeholder="Station latitude"/>
                                                            </div>
                                                        </div>
                                                        <div>

                                                            <!-- Submit form -->
                                                            <input type='submit' class='btn' value='Add station'/>


                        <!-- Input ends -->
                    </div>
                </div>
            </div>
        </div>
    </form:form>

    <!-- Container ends -->
</div>

</body>
</html>
