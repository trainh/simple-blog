<%-- 
    Document   : article-page
    Created on : Sep 27, 2021, 3:32:05 PM
    Author     : trainh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/css_article_page.css" rel="stylesheet" type="text/css"/>
        <script src="js/js.js" type="text/javascript"></script>
        <title>Article Details Page</title>
    </head>
    <body>
        <h1><a href="choosePageAction">Simple Bog</a></h1>
        <div class="function">
            <c:if test="${sessionScope.USER == null}">
                <a href="loginHtmlPage">LOGIN</a>
            </c:if>
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
        <p class="comment-tile">Comment!</p>
        <div class="comment">
            <c:if test="${requestScope.COMMENTLIST != null}">
                <c:forEach items="${requestScope.COMMENTLIST}" var="c">
                    <p>${c.email}: ${c.comment}</p>
                </c:forEach>
            </c:if>
            <c:if test="${requestScope.COMMENTLIST.size() == 0}">
                <h3>To be the first person to comment!</h3>
            </c:if>
        </div>
        <div class="inputcomment">
            <form action="commentArticleAction" onsubmit="return validateFormComment()" name="commentForm">
                <input type="text" name="txtComment" value="${txtCommnet}" /><br/>
                <input type="submit" name="bntAction" value="Commnet" /><br/>
                <input type="hidden" name="txtEmail" value="${sessionScope.USER.email}" />
                <input type="hidden" name="txtArticleID" value="${requestScope.ARTICLE.articleID}" />
            </form>
        </div>
        <style>
            .article #description p:nth-child(2) {
                text-align: right;
            }
            .comment-tile {
                margin: 0;
            }
            .inputcomment input {
                margin: 10px 0 10px 0;
            }
        </style>
    </body>
</html>
