<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<t:dashboard_layout title="Course Update" menu_name="Course Update">
	<jsp:attribute name="form_area">
		<div class="center">
		    <div class="search-wrapper">
	            <div class="bot-gap">
	                <form action="${pageContext.request.contextPath}/update-course" method="post">
			            <input type="hidden" name="id" value="${course.id}"><br>
			            <input type="text" name="description" value="${course.description}"><br>
			            <select name="teacherId">
						    <c:forEach var="teacher" items="${teachers}">
						        <option value="${teacher.id}" <c:if test="${teacher.id eq selectedTeacherId}">selected="selected"</c:if>>${teacher.id}. ${teacher.lastname} ${teacher.firstname}</option>
						    </c:forEach>
						</select>
						<br><br>
			            <button type="submit" class="insert-btn rounded btn btn-primary">Update Course</button>
			        </form>
	            </div>
	        </div>
	    </div>
	</jsp:attribute>
</t:dashboard_layout>