<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
</head>
<body>
    <div class="container-fluid">
        <div class="container">
            <div class="row">
                <h1>Administrator Login</h1>
            </div>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="row">
                    <input type="email" name="eMail" required placeholder="E-Mail" autofocus>
                </div>
                <div class="row">
                    <input type="password" name="password" required placeholder="Password">
                </div>
                <div class="row">
                    <button type="submit">Sign In</button>
                </div>
            </form>
            <div class="row text-grey">
                <a href="#">Lost your password?</a>
            </div>
        </div>
        <div class="row">
            <p>
                Don't have an account? <a href="#">Sign up here!</a>
            </p>
        </div>
    </div>
    <div class="container-error">
            <c:if test="${error}">
                <p>Login Error</p>
            </c:if> 
        </div>
</body>
</html>