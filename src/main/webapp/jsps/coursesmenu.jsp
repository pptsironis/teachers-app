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
	                <form action="${pageContext.request.contextPath}/search-course" method="get">
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
	                <form action="${pageContext.request.contextPath}/insert-course" method="post">
	                    <input type="text" name="description" id="description" class="insert rounded" placeholder="description" required>
	                    <br>
		                <select name="teacherId">
						    <c:forEach var="teacher" items="${teachers}">
						        <option value="${teacher.id}" <c:if test="${teacher.id eq selectedTeacherId}">selected="selected"</c:if>>${teacher.id}. ${teacher.lastname} ${teacher.firstname}</option>
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
    <div class="center"> 
        <c:if test="${wasInserted}">
            <p class="text-success">Course ${insertedCourse.description} was inserted successfully</p>
        </c:if>
	</div>
	<div class="center"> 
	        <c:if test="${wasDeleted}">
	            <p class="text-success">Course ${deletedCourse.description} was deleted successfully</p>
	        </c:if>
		</div>
		<div class="center"> 
	        <c:if test="${wasUpdated}">
	            <p class="text-success">Course ${updatedCourse.description} was updated successfully</p>
	        </c:if>
		</div>
</jsp:attribute>
<jsp:attribute name="table_area">
	<c:if test="${hasTable}">
		<h2>Courses</h2>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <thead>
                    <tr>
						<th>ID</th>
				        <th>Description</th>
				        <th>TeacherId</th>
				        <th>Delete</th>
				        <th>Update</th>
				        <th>Students</th>
				    </tr>
                </thead>
                <tbody>
                    <c:forEach var="course" items="${courses}">
					   <tr>
					       <td>${course.id}</td>
					       <td>${course.description}</td>
					       <td>${course.teacherId}</td>
					       <td><a href="${pageContext.request.contextPath}/delete-course?id=${course.id}&description=${course.description}&teacherId=${course.teacherId}" class="btn btn-outline-danger btn-sm">Delete</a></td>
					       <td><a href="${pageContext.request.contextPath}/update-course?id=${course.id}&description=${course.description}&teacherId=${course.teacherId}" class="btn btn-outline-primary btn-sm">Update</a></td>
					       <td><a href="${pageContext.request.contextPath}/course-students?id=${course.id}&description=${course.description}&teacherId=${course.teacherId}" class="btn btn-outline-primary btn-sm">Add/Remove</a></td>
					   </tr>
					</c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</jsp:attribute>
</t:dashboard_layout>
</html>