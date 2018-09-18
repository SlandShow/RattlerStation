<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager role: schedule creation</title>
</head>
<body>
<div>
    <form:form action="createSchedule" method="POST" modelAttribute="schedule">
        Station departure name:
        <<form:input type="text" path="stationDepartureName" id="stationDepartureName"/>
        <br><br>
        Station arrival name:
        <<form:input type="text" path="stationArrivalName" id="stationArrivalName"/>
        <br><br>
        Train name:
        <<form:input type="text" path="trainName" id="trainName"/>
        <br><br>
        Date departure:
        <<form:input type="text" path="dateDeparture" id="dateDeparture"/>
        <br><br>
        Date arrival:
        <<form:input type="text" path="dateArrival" id="dateArrival"/>
        <br><br>
        <input type="submit" value="Add"/>
    </form:form>
</div>
</body>
</html>
