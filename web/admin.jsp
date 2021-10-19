<%-- 
    Document   : admin
    Created on : Oct 1, 2021, 12:15:10 PM
    Author     : trainh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/css-admin.css" rel="stylesheet" type="text/css"/>
        <title>Admin Page</title>
    </head>
    <body>
        <h1><a href="choosePageAction">Simple Bog</a></h1>
        <h3>Hello Admin!</h3>
        <h4><a href="adminJspPage">Home Admin</a></h4>
        <div class="form-search">
            <c:set var="searchContent" scope="page" value="${param.txtSearchContent}"></c:set>
            <c:set var="searchTital" scope="page" value="${param.txtSearchTital}"></c:set>
                <form action="searchArticleAction" onsubmit="return validateSearch()" name="searchForm">
                    <div class="search">
                        <input type="text" name="txtSearchTital" value="${pageScope.searchTital}" placeholder="Search tatil"/>
                    <input type="text" name="txtSearchContent" value="${pageScope.searchContent}" placeholder="Search content"/>
                    <input type="submit" name="bntAcion" value="Search" />
                </div>
            </form>
                <div class="status-search">
                    <c:set var="listStatus" value="${sessionScope.STATUS_ARTICLE_QUANTITY}"></c:set>
                    <a href="searchArticleAction?status=1">New (${listStatus.get(0)})</a><br/>
                    <a href="searchArticleAction?status=2">Active (${listStatus.get(1)})</a><br/>
                    <a href="searchArticleAction?status=5">Delete (${listStatus.get(2)})</a><br/>
                </div>
            </div>
        </div>
        <c:forEach items="${requestScope.LIST_ARTICLE}" var="article">
            <div class="article">
                <div class="hearderarticle">
                    <p id="tital">${article.tital}</p>
                    <p id="author">Author: ${article.author}</p>
                </div>
                <div>
                    <p id="description">${article.shortDescription}<a href="editArticleAction?bntAction=view&articleID=${article.articleID}"> see more</a></p>
                </div>
                <div>
                    <p id="dateCreate">Date: ${article.date}</p>
                </div>
            </div>
        </c:forEach>
        <c:if test="${requestScope.LIST_ARTICLE.size() == 0}">
            <h3>There aren't articles</h3>
        </c:if>
        <div class="page">
            <c:forEach begin="1" end="${requestScope.QUANTITY_PAGE}" var="num">
                <a href="searchArticleAction?posPage=${num}&txtSearchContent=${param.txtSearchContent}&txtSearchTital=${pageScope.searchTital}&status=${requestScope.status}">${num}</a>
            </c:forEach>
        </div>
        <script>
            function  validateSearch() {
                var txtSearchTital = document.searchForm.txtSearchTital.value;
                var txtSearchContent = document.searchForm.txtSearchContent.value;
                if ((txtSearchContent === null || txtSearchContent === "") && (txtSearchTital === null || txtSearchTital === "")) {
                    alert("Search Tital or Search Content can't be felt blank!!!");
                    return false;
                }
            }
        </script>
    </body>
</html>
