<%-- 
    Document   : invalid
    Created on : Sep 27, 2021, 5:14:38 PM
    Author     : trainh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Page</title>
    </head>
    <body>
        <h3>${requestScope.ERROR_STRING}</h3>
        <h3>${sessionScope.ERROR_STRING}</h3>
        <c:remove scope="session" var="ERROR_STRING"></c:remove>
        <a href="choosePageAction">Comeback Home Page</a>
    </body>
</html>
