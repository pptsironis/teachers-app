<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<t:dashboard_layout title="Student Update" menu_name="Student Update">
	<jsp:attribute name="form_area">
		<div class="center">
		    <div class="search-wrapper">
	            <div class="bot-gap">
	                <form action="${pageContext.request.contextPath}/update-student" method="post">
			            <input type="hidden" name="id" value="${student.id}"><br>
			            <input type="text" name="firstname" value="${student.firstname}"><br>
			            <input type="text" name="lastname" value="${student.lastname}"><br><br>
			            <button type="submit" class="insert-btn rounded btn btn-primary">Update Student</button>
			        </form>
	            </div>
	        </div>
	    </div>
	</jsp:attribute>
</t:dashboard_layout>