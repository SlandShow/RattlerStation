<!-- JSP View, which list all Stations -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List Stations</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
          integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>List of Stations</h2>
        </div>
    </div>

    <div class="container">

        <!-- Add HTML table -->
        <table class="table table-striped">

            <tr>
                <th>Station name</th>
            </tr>

            <!-- Loop over and print stations  -->
            <c:forEach var="tmpStation" items="${stations}">
                <tr>
                    <td> ${tmpStation.name} </td>
                </tr>
            </c:forEach>

        </table>

    </div>

</body>
</html>
