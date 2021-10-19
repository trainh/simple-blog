<%-- 
    Document   : register
    Created on : Sep 25, 2021, 8:29:49 PM
    Author     : trainh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/css-form.css" rel="stylesheet" type="text/css"/>
        <script src="js/js.js" type="text/javascript"></script>
    </head>
    <body>
        <h1><a href="choosePageAction">Simple Log</a></h1>
        <h2>Sign Up</h2>
        <div>
            <form action="registerAction" method="POST" onsubmit="return validateForm()" name="registerForm">
                Email <input type="email" name="txtEmail" value="" />${sessionScope.ErrorRegisterAccount.emailRegisterError}<br/>
                Name <input type="text" name="txtName" value="" />${sessionScope.ErrorRegisterAccount.nameRegisterError}<br/>
                Password <input type="password" name="txtPassword" value="" />${sessionScope.ErrorRegisterAccount.passwordRegisterError}<br/>
                <input type="submit" name="bntAction" value="Sign Up" />
            </form>
                <h2>${sessionScope.StatusRegisterAccount}</h2>
                <a href="loginHtmlPage">Comeback Login Page</a>
                <c:remove var="ErrorRegisterAccount" scope="session"></c:remove>
                <c:remove var="StatusRegisterAccount" scope="session"></c:remove>
        </div>
    </body>
</html>
