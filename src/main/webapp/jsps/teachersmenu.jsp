<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<t:dashboard_layout title="Teachers Menu" menu_name="Teachers Menu">
<jsp:attribute name="form_area">
	<div class="center">
        <div class="search-wrapper">
            <div class="bot-gap">
                <span class="title">Search Teacher</span>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/search-teacher" method="get">
                    <input type="text" name="lastname" id="lastname" class="search rounded" placeholder="Insert teacher's lastname" autofocus>
                    <br><br>
                    <button type="submit" class="search-btn rounded btn btn-primary">Search</button>
                </form>
            </div>
        </div>
        <div class="insert-wrapper">
            <div class="bot-gap">
                <span class="title">Insert Teacher</span>
            </div>
            <div class="bot-gap">
                <form action="${pageContext.request.contextPath}/insert-teacher" method="post">
                    <input type="text" name="lastname" id="lastname" class="insert rounded" placeholder="lastname" required>
                    <br>
                    <input type="text" name="firstname" id="firstname" class="insert rounded" placeholder="firstname" required>
                    <br><br>
                    <button type="submit" class="insert-btn rounded btn btn-primary">Insert</button>
                </form>
            </div>
    </div>
    
    </div>
    <div class="center"> 
        <c:if test="${sqlError}">
            <p class="text-danger">Error in Insert</p>
        </c:if>
    </div>
    <div class="center"> 
        <c:if test="${teacherNotFound}">
            <p class="text-danger">Teacher not found</p>
        </c:if>
    </div>
</jsp:attribute>
</t:dashboard_layout>
</html>