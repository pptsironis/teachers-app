<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<t:dashboard_layout title="Courses Menu" menu_name="Courses Menu">
<jsp:attribute name="form_area">
	<div class="center">
	    <div class="search-wrapper">
	            <div class="bot-gap">
	                <span class="title">Search Course</span>
	            </div>
	            <div class="bot-gap">
	                <form action="${pageContext.request.contextPath}/search-student" method="get">
	                    <input type="text" name="description" id="description" class="search rounded" placeholder="Insert course's description" autofocus>
	                    <br><br>
	                    <button type="submit" class="search-btn rounded btn btn-primary">Search</button>
	                </form>
	            </div>
	        </div>
	        <div class="insert-wrapper">
	            <div class="bot-gap">
	                <span class="title">Insert Course</span>
	            </div>
	            <div class="bot-gap">
	                <form action="${pageContext.request.contextPath}/insert-student" method="post">
	                    <input type="text" name="description" id="description" class="insert rounded" placeholder="description" required>
	                    <br>
	                    <select name="teacherId">
						    <c:forEach var="teacher" items="${teachers}">
						        <option value="${teacher.id}">${teacher.id}. ${teacher.lastname} ${teacher.firstname}</option>
						    </c:forEach>
						</select>
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
        <c:if test="${courseNotFound}">
            <p class="text-danger">Course not found</p>
        </c:if>
    </div>
</jsp:attribute>
</t:dashboard_layout>
</html>