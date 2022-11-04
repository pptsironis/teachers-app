<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<t:dashboard_layout title="Students Menu" menu_name="Students Menu">
	<jsp:attribute name="form_area">
		<div class="center">
		    <div class="search-wrapper">
		            <div class="bot-gap">
		                <span class="title">Search Student</span>
		            </div>
		            <div class="bot-gap">
		                <form action="${pageContext.request.contextPath}/search-student" method="get">
		                    <input type="text" name="lastname" id="lastname" class="search rounded" placeholder="Insert student's lastname" autofocus>
		                    <br><br>
		                    <button type="submit" class="search-btn rounded btn btn-primary">Search</button>
		                </form>
		            </div>
		        </div>
		        <div class="insert-wrapper">
		            <div class="bot-gap">
		                <span class="title">Insert Student</span>
		            </div>
		            <div class="bot-gap">
		                <form action="${pageContext.request.contextPath}/insert-student" method="post">
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
	        <c:if test="${studentNotFound}">
	            <p class="text-danger">Student not found</p>
	        </c:if>
	    </div>
	    <div class="center"> 
	        <c:if test="${wasInserted}">
	            <p class="text-success">Student ${insertedStudent.lastname} ${insertedStudent.firstname} was inserted successfully</p>
	        </c:if>
		</div>
		<div class="center"> 
	        <c:if test="${wasDeleted}">
	            <p class="text-success">Student ${deletedStudent.lastname} ${deletedStudent.firstname} was deleted successfully</p>
	        </c:if>
		</div>
		<div class="center"> 
	        <c:if test="${wasUpdated}">
	            <p class="text-success">Student ${updatedStudent.lastname} ${updatedStudent.firstname} was updated successfully</p>
	        </c:if>
		</div>
	</jsp:attribute>
	<jsp:attribute name="table_area">
		<c:if test="${hasTable}">
			<h2>Students</h2>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                        <tr>
							<th>ID</th>
					        <th>Firstname</th>
					        <th>Lastname</th>
					        <th>Delete</th>
					        <th>Update</th>
					        <th>Courses</th>
					    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${students}">
						   <tr>
						       <td>${student.id}</td>
						       <td>${student.firstname}</td>
						       <td>${student.lastname}</td>
						       <td><a href="${pageContext.request.contextPath}/delete-student?id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}" class="btn btn-outline-danger btn-sm">Delete</a></td>
						       <td><a href="${pageContext.request.contextPath}/update-student?id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}" class="btn btn-outline-primary btn-sm">Update</a></td>
						       <td><a href="${pageContext.request.contextPath}/student-courses?id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}" class="btn btn-outline-primary btn-sm">Add/Remove</a></td>
						   </tr>
						</c:forEach>
                    </tbody>
                </table>
            </div>
	    </c:if>
	</jsp:attribute>
</t:dashboard_layout>