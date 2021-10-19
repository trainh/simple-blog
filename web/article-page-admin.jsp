<%-- 
    Document   : article-page-admin
    Created on : Oct 1, 2021, 6:06:47 PM
    Author     : trainh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/css_article_page.css" rel="stylesheet" type="text/css"/>
        <title>Article Page Admin Page</title>
    </head>
    <body>
        <h1><a href="choosePageAction">Simple Bog</a></h1>
        <div class="function">
            <c:if test="${sessionScope.USER != null}">
                <h1>Hello ${sessionScope.USER.name}!</h1>
                <a href="logoutAction">LOGOUT</a>
            </c:if>
        </div>
        <div class="article">
            <div id="hearder">
                <h2>${requestScope.ARTICLE.tital}</h2>
                <h4>${requestScope.ARTICLE.author}</h4>
            </div>
            <div id="description">
                <p>${requestScope.ARTICLE.contentArticle}</p>
                <p>Publication date: ${requestScope.ARTICLE.date}</p>
            </div>
        </div>
        <div>
            <form action="editArticleAction">
                <input type="hidden" name="articleID" value="${requestScope.ARTICLE.articleID}" />
                <c:if test="${requestScope.ARTICLE.status == 1 }">                    
                    <input type="submit" name="bntAction" value="Approve" />
                </c:if>
                <c:if test="${requestScope.ARTICLE.status == 1 || requestScope.ARTICLE.status == 2}">                    
                    <input type="submit" name="bntAction" value="Delete" />
                </c:if>
                <c:if test="${requestScope.ARTICLE.status == 5}">                    
                    <input type="submit" name="bntAction" value="Active" />
                </c:if>
            </form> 
        </div>
    </body>
</html>
