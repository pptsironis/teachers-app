<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<t:dashboard_layout title="Student's Courses" menu_name="${student.lastname} ${student.firstname}  Courses">
	<jsp:attribute name="table_area">
		<c:if test="${hasCourses}">
			<h2>Student's Courses</h2>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                        <tr>
							<th>ID</th>
					        <th>Description</th>
					        <th>Delete</th>
					    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="course" items="${studentCourses}">
						   <tr>
						       <td>${course.id}</td>
						       <td>${course.description}</td>
						       <td><a href="${pageContext.request.contextPath}/delete-screlation?studentId=${student.id}&courseId=${course.id}&id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}" class="btn btn-outline-danger btn-sm">Remove Course</a></td>
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
					        <th>Description</th>
					        <th>Delete</th>
					    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="course" items="${notStudentCourses}">
						   <tr>
						       <td>${course.id}</td>
						       <td>${course.description}</td>
						       <td><a href="${pageContext.request.contextPath}/insert-screlation?studentId=${student.id}&courseId=${course.id}&id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}" class="btn btn-outline-success btn-sm">Add Course</a></td>
						   </tr>
						</c:forEach>
                    </tbody>
                </table>
            </div>
	    </c:if>
	</jsp:attribute>
</t:dashboard_layout>

