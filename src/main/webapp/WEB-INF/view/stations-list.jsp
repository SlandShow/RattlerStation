<!-- JSP View, which list all Stations -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List Stations</title>
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>List of Stations</h2>
        </div>
    </div>

    <div id="container">

        <div id="content">

        <!-- Add HTML table -->
        <table>

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

    </div>

</body>
</html>
