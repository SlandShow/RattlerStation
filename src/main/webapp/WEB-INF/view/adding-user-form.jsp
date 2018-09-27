<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding User</title>
    <!-- Add bootstrap -->
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container">

        <h2 class="text-info">Admin: Create user</h2>

        <form:form action="addUser" method="POST" modelAttribute="user">

            <div class="form-group col-md-6">
                <label for="inputUserName">Name</label>
                <form:input type="text" path="firstName" id="inputUserName" class="form-control"  placeholder="Enter person name"/>
            </div>

            <div class="form-group col-md-6">
                <label for="inputuserLastname">Lastname</label>
                <form:input type="text" path="lastName" id="inputuserLastname" class="form-control"  placeholder="Carriages"/>
            </div>

            <div class="form-group col-md-6">
                <label for="inputLogin">Login</label>
                <form:input type="text" path="login" id="inputLogin" class="form-control" placeholder="Seats"/>
            </div>


            <div class="form-group col-md-6">
                <label for="inputPass">Password</label>
                <form:input type="password" path="password" id="inputPass" class="form-control" placeholder="Password" min="4"/>
            </div>

            <input type="radio" name="role" value="USER_ROLE" checked> User<br>
            <input type="radio" name="role" value="MANAGER_ROLE"> Manager<br>

            <br>
            <center><input type="submit" class="btn btn-primary" value="Add person"/></center>
        </form:form>

    </div>

</body>
</html>
