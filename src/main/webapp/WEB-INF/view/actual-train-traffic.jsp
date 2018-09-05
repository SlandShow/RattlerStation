<!-- JSP for schedule selection -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Actual train traffic</title>
</head>
<body>


<form:form action="scheduleByStationsAndDate" method="POST" modelAttribute="schedule">
    <form:input type="hidden" path="id" id="id"/>

    <<form:input path="stationDeparture" id="stationDeparture"/>
    <<form:input path="stationArrival" id="stationArrival"/>
    <<form:input path="dateDeparture" id="dateDeparture"/>

    <input type="submit" value="Register"/>
</form:form>

</body>
</html>
