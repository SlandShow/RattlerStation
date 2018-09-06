<!-- JSP for schedule selection -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Actual train traffic</title>
</head>
<body>

<div>
    <form:form action="scheduleByStationsAndDate" method="POST" modelAttribute="schedule">
        <form:input type="hidden" path="id" id="id"/>

        <<form:input type="text" path="stationDepartureName" id="stationDeparture"/>
        <<form:input type="text" path="stationArrivalName" id="stationArrival"/>
        <<form:input type="text" path="dateDeparture" id="dateDeparture"/>

        <input type="submit" value="Search"/>
    </form:form>
</div>

</body>
</html>
