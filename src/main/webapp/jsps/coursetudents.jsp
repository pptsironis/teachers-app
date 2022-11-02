<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<t:dashboard_layout title="Course's Students" menu_name="${course.description} Students">
	<jsp:attribute name="table_area">
		<c:if test="${hasStudents}">
			<h2>Course's Students</h2>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                        <tr>
							<th>ID</th>
					        <th>Lastname</th>
					        <th>Firstname</th>
					        <th>Delete</th>
					    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${courseStudents}">
						   <tr>
						       <td>${student.id}</td>
						       <td>${student.firstname}</td>
						       <td>${student.lastname}</td>
						       <td><a href="${pageContext.request.contextPath}/delete-csrelation?studentId=${student.id}&courseId=${course.id}&id=${course.id}&description=${course.description}&teacherId=${course.teacherId}" class="btn btn-outline-danger btn-sm">Remove Student</a></td>
						   </tr>
						</c:forEach>
                    </tbody>
                </table>
            </div>
	    </c:if>
		<c:if test="${hasTable}">
			<h2>Courses not attending</h2>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                        <tr>
							<th>ID</th>
					        <th>Lastname</th>
					        <th>Firstname</th>
					        <th>Add</th>
					    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${notCourseStudents}">
						   <tr>
						       <td>${student.id}</td>
						       <td>${student.firstname}</td>
						       <td>${student.lastname}</td>
						       <td><a href="${pageContext.request.contextPath}/insert-csrelation?studentId=${student.id}&courseId=${course.id}&id=${course.id}&description=${course.description}&teacherId=${course.teacherId}" class="btn btn-outline-success btn-sm">Add Student</a></td>
						   </tr>
						</c:forEach>
                    </tbody>
                </table>
            </div>
	    </c:if>
	</jsp:attribute>
</t:dashboard_layout>

