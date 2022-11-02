<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<t:dashboard_layout title="Teacher Update" menu_name="Teacher Update">
	<jsp:attribute name="form_area">
		<div class="center">
		    <div class="search-wrapper">
	            <div class="bot-gap">
	                <form action="${pageContext.request.contextPath}/update-teacher" method="post">
			            <input type="hidden" name="id" value="${teacher.id}"><br>
			            <input type="text" name="firstname" value="${teacher.firstname}"><br>
			            <input type="text" name="lastname" value="${teacher.lastname}"><br><br>
			            <button type="submit" class="insert-btn rounded btn btn-primary">Update Teacher</button>
			        </form>
	            </div>
	        </div>
	    </div>
	</jsp:attribute>
</t:dashboard_layout>