<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/teachersmenu.css">
<title>Teachers Search</title>
</head>
<body>
    <div class="center">
        <div class="search-wrapper">
            <div class="bot-gap">
                <span class="title">Teachers Search</span>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/search" method="get">
                    <input type="text" name="lastname" id="lastname" class="search rounded" placeholder="Insert teacher's lastname" autofocus>
                    <br><br>
                    <button type="submit" class="search-btn rounded color-btn">Search</button>
                </form>
            </div>
        </div>
        <div class="insert-wrapper">
            <div class="bot-gap">
                <span class="title">Teachers Insert</span>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/insert" method="post">
                    <input type="text" name="lastname" id="lastname" class="insert rounded" placeholder="lastname" autofocus required>
                    <br>
                    <input type="text" name="firstname" id="firstname" class="insert rounded" placeholder="firstname" required>
                    <br><br>
                    <button type="submit" class="insert-btn rounded color-btn">Insert</button>
                </form>
            </div>
    </div>
    </div>
    <div class="center"> 
        <c:if test="${sqlError}">
            <p>Error in Insert</p>
        </c:if>
    </div>
    <div class="center"> 
        <c:if test="${teacherNotFound}">
            <p>Teacher not found</p>
        </c:if>
    </div>
</body>
</html>