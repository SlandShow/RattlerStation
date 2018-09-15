<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage trains: creation</title>
</head>
<body>
    <div>
        <form:form action="createTrain" method="POST" modelAttribute="train">
            Train name:
            <<form:input type="text" path="name" id="name"/>
            <br><br>
            Carriage count:
            <<form:input type="number" min="1" max="30" path="carriageCount" id="carriageCount"/>
            <br><br>
            Seats count:
            <<form:input type="number" path="seatsCount" id="seatsCount"/>
            <br><br>

            <input type="submit" value="Add"/>
        </form:form>
    </div>
</body>
</html>
