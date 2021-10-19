<%-- 
    Document   : post
    Created on : Sep 29, 2021, 11:07:02 PM
    Author     : trainh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post Page</title>
    </head>
    <body>
        <h1><a href="choosePageAction">Simple Bog</a></h1>
        <h2>Post Page</h2>
        <div class="function">
            <a href="logoutAction">LOGOUT</a>
        </div>
        <div>
            <form action="postArticleAction" onsubmit="return validatePost()" name="postForm">
                <h4>Title</h4><br/>
                <textarea name="txtTital" rows="1" cols="100">
                    
                </textarea>
                <h4>Short Description</h4><br/>
                <textarea name="txtShortDescription" rows="4" cols="100">
                    
                </textarea>
                <h4>Content</h4><br/>
                <textarea name="txtContentArticle" rows="8" cols="100">
                    
                </textarea>
                <div>
                    <input type="submit" name="bntAction" value="Post" />
                </div>
            </form>
        </div>
        <h2>${sessionScope.STATUS_POST}</h2>
        <c:remove scope="session" var="STATUS_POST"></c:remove>
    </body>
</html>
