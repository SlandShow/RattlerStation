<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy ticket</title>
</head>
<body>
    <div>
            <form:form action="buyTicket" method="POST" modelAttribute="ticket">
                <form:input type="hidden" path="id" id="id"/>

                Station departure:
                <<form:input path="scheduleStationDepartureName" />
                <br><br>

                Station arrival:
                <<form:input path="scheduleStationArrivalName" />
                <br><br>

                Date departure:
                <<form:input path="scheduleDateDeparture" />
                <br><br>

                Your login:
                <<form:input path="userLogin" />
                <br><br>

                Carriage number:
                <<form:input path="seatCarriage" />
                <br><br>

                Seat number:
                <<form:input path="seatSeat" />
                <br><br>

                <input type="submit" value="Search"/>
            </form:form>
    </div>
</body>
</html>
