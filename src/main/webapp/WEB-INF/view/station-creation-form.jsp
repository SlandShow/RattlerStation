<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager tools: station creation</title>
</head>
<body>
    <div>
        <form:form action="createStation" method="POST" modelAttribute="station" accept-charset="UTF-8">
            Station name:
            <<form:input type="text" path="name" id="name"/>
            <br><br>
            Latitude:
            <<form:input type="number" step="0.000001" path="latitude" id="latitude"/>
            <br><br>
            Longitude:
            <<form:input type="number" step="0.000001" path="longitude" id="longitude"/>
            <br><br>

            <input type="submit" value="Add"/>
        </form:form>
    </div>
</body>
</html>
