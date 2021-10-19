<%-- 
    Document   : login
    Created on : Sep 24, 2021, 10:17:25 PM
    Author     : trainh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1><a href="choosePageAction">Simple Log</a></h1>
        <h2>Login Page</h2>
        <h4><a href="registerHtmlPage">Sing Up</a></h4>
        <form action="loginAction" method="POST">
            Email: <input type="text" name="txtEmail" value="" /><br/>
            Password: <input type="password" name="txtPassword" value="" /><br/>
            <input type="submit" value="Login" name="bntAction" /><br/>
        </form>
        <h2>${sessionScope.ErrorStringLogin}</h2>
        <c:remove scope="session" var="ErrorStringLogin"></c:remove>
        <style>
            input {
                margin: 10px;
            }
        </style>
    </body>
</html>
