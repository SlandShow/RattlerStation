<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div class="login-page">
        <form class="form" action="/login" method="post">
            <input name="login" id="userNameUser" type="email" placeholder="login" required/>
            <input name="password" id="passwordUser" type="password" placeholder="password" required/>
            <button id="loginUser">Sign in</button>
            <p class="message">Not registered? <a href="/registration">Create an account</a></p>
        </form>
        <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
            <script>
                swal({
                    title: 'Oops..',
                    text: 'Wrong login or password. Try again!',
                    type: 'error'
                });
            </script>
        </c:if>
    </div>
</body>
</html>
