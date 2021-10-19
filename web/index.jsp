<%-- 
    Document   : index
    Created on : Sep 25, 2021, 9:05:44 PM
    Author     : trainh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/css-form.css" rel="stylesheet" type="text/css"/>
        <title>Index Page</title>
    </head>
    <body>
        <c:if test="${requestScope.QUANTITY_PAGE == null || requestScope.LIST_ARTICLE == null}">
            <c:redirect url="choosePageAction"></c:redirect>
        </c:if>
        <h1><a href="choosePageAction">Simple Blog</a></h1>

        <div class="function">
            <c:if test="${sessionScope.USER == null}">
                <a href="loginHtmlPage">LOGIN</a>
            </c:if>
            <c:if test="${sessionScope.USER != null}">
                <h1>Hello ${sessionScope.USER.name}!</h1>
                <a href="logoutAction">LOGOUT</a>
            </c:if>
            <c:if test="${sessionScope.USER.role == 1}">
                <a href="getQuantityOfStatusArticleAction">ADMIN</a>
            </c:if>
        </div>
        <div class="search">
            <form action="choosePageAction" onsubmit="return validateFormSearch()" name="searchForm">
                <input type="text" name="search" value="${requestScope.search}" />
                <input type="submit" name="bntAction" value="Search" />
            </form>
            <c:if test="${sessionScope.USER == null || sessionScope.USER.role == 2}">
                <h4><a href="postArticleHtmlPage">Post Article</a></h4>
                </c:if>
        </div>
        <c:forEach items="${requestScope.LIST_ARTICLE}" var="article">
            <div class="article">
                <div class="hearderarticle">
                    <p id="tital">${article.tital}</p>
                    <p id="author">Author: ${article.author}</p>
                </div>
                <div>
                    <p id="description">${article.shortDescription}<a href="getArticleDetailsAction?articleID=${article.articleID}"> see more</a></p>
                </div>
                <div>
                    <p id="dateCreate">Date: ${article.date}</p>
                </div>
            </div>
        </c:forEach>
        <div class="page">
            <c:forEach begin="1" end="${requestScope.QUANTITY_PAGE}" var="num">
                <a href="choosePageAction?posPage=${num}&search=${requestScope.search}">${num}</a>
            </c:forEach>
        </div>
        <c:remove scope="session" var="ErrorStringLogin"></c:remove>
        <script>
            function validateFormSearch() {
                var search = document.searchForm.search.value;
                if (search === null || search === "") {
                    alert("Search can't be left blank!!!");
                    return false;
                }
            }
        </script>
    </body>
</html>
