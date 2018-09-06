<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <div class="login-page">
        <form class="form">
            <input id="firstName" type="text" placeholder="firstName" required/>
            <input id="lastName" type="text" placeholder="lastName" required/>
            <input id="login" type="email" placeholder="e-mail address" required/>
            <input id="password" type="password" placeholder="password" required/>
            <button id="registrationBtn" type="submit">create</button>
            <p class="message">Already registered? <a href="/login">Sign In</a></p>
        </form>
    </div>
</body>
</html>
