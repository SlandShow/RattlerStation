<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager: schedule creation</title>
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

    <!-- Bootstrap container -->

    <form:form action="createSchedule" method="POST" modelAttribute="scheduleCreation">

    <!-- Form start -->


    <legend>Create schedule</legend>


    <div class="row" style="width: 500px;display: block;margin: 0 auto;">
        <div class='col-sm-0'>
            <div class="form-group">
                <div class="input-group">

                    <!-- Input elements -->

                    <!-- Station departure -->

                    <div class="row">
                        <div class='col-sm-12'>
                            <div class="form-group">
                                <div class="input-group">
                                    <form:input type="text" path="stationDepartureName" id="stationDepartureName" class="form-control" placeholder="Station Departure"/>
                                </div>
                            </div>
                            <div>


                                <div class="row">
                                    <div class='col-sm-12'>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <form:input type="text" path="stationArrivalName" id="stationArrivalName" class="form-control" placeholder="Station Arrival"/>
                                            </div>
                                        </div>
                                        <div>


                                            <div class="row">
                                                <div class='col-sm-12'>
                                                    <div class="form-group">
                                                        <div class="input-group">
                                                            <form:input type="text" path="trainName" id="trainName" class="form-control" placeholder="Train name"/>
                                                        </div>
                                                    </div>
                                                    <div>


                                                        <div class="row">
                                                            <div class='col-sm-12'>
                                                                <div class="form-group">
                                                                    <div class='input-group date' id='datetimepicker1'>
                                                                        <form:input type="text" path="dateDeparture" id="dateDeparture" class="form-control"/>
                                                                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class='col-sm-12'>
                                                                <div class="form-group">
                                                                    <div class='input-group date' id='datetimepicker2'>
                                                                        <form:input type="text" path="dateArrival" id="dateArrival" class="form-control"/>
                                                                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <br>






                    <!-- Input elements ends -->
                </div>
                                                    <input type="submit" class="btn" value="Confirm schedule adding"/>
            </div>
            <div>
            </div>


            <!-- Form end -->

            </form:form>
        </div>

    </div>


   <!-- Bootstrap container -->


</div>

                                            <script>
                                                $('#datetimepicker1').datetimepicker({
                                                    defaultDate: new Date(),
                                                    format: 'DD/MM/YYYY hh:mm:ss A',
                                                    sideBySide: true
                                                });

                                                $('#datetimepicker2').datetimepicker({
                                                    defaultDate: new Date(),
                                                    format: 'DD/MM/YYYY hh:mm:ss A',
                                                    sideBySide: true
                                                });
                                            </script>
</body>
</html>
