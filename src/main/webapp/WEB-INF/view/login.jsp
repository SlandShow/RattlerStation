<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Login</title>

    <style>
        body {
            background: #003973;  /* fallback for old browsers */
            background: -webkit-linear-gradient(to right, #E5E5BE, #003973);  /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to right, #E5E5BE, #003973); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
        }

        .login {
            margin: 20px auto;
            width: 300px;
            padding: 30px 25px;
            background: white;
            border: 1px solid #c4c4c4;
        }

        h1.login-title {
            margin: -28px -25px 25px;
            padding: 15px 25px;
            line-height: 30px;
            font-size: 25px;
            font-weight: 300;
            font-family: sans-serif;
            color: #4c5866;
            text-align:center;
            background: #f7f7f7;

        }

        .login-input {
            width: 285px;
            height: 50px;
            margin-bottom: 25px;
            padding-left:10px;
            font-size: 15px;
            background: #fff;  /* fallback for old browsers */
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .login-input:focus {
            border-color:#6e8095;
            outline: none;
        }

        .login-button {
            width: 100%;
            height: 50px;
            padding: 0;
            font-size: 20px;
            color: #fff;
            text-align: center;
            background: #3494E6;  /* fallback for old browsers */
            background: -webkit-linear-gradient(to right, #EC6EAD, #3494E6);  /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to right, #EC6EAD, #3494E6); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            border: 0;
            border-radius: 5px;
            cursor: pointer;
            outline:0;
        }

        .login-button:hover {
            background: #360033;  /* fallback for old browsers */
            background: -webkit-linear-gradient(to right, #0b8793, #360033);  /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to right, #0b8793, #360033); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

        }

        .login-lost
        {
            text-align:center;
            margin-bottom:0px;
        }

        .login-lost a
        {
            color: #595353;
            text-decoration:none;
            font-size: 20px;
        }

        .login-lost a:hover {
            color: black;
        }
    </style>
</head>
<body>


<div class="login-page">
    <form class="login" action="/login" method="post">
        <h1 class="login-title">Enjoy your Rattler! 🚇</h1>
        <input type="text" class="login-input" placeholder="Email Adress" id="userNameUser" name="login" required>
        <input type="password" class="login-input" placeholder="Password" id="passwordUser" name="password" required>
        <input type="submit" value="Lets Go" class="login-button">
        <p class="login-lost"><a href="/registration">Don't have acount?</a></p>
    </form>
</div>

</body>
</html>
