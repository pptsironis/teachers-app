<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teachers Found</title>
</head>
<body>
<div>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="teacher" items="${teachers}">
                <tr>
                    <td>${teacher.id}</td>
                    <td>${teacher.firstname}</td>
                    <td>${teacher.lastname}</td>
                    <td><a href="${pageContext.request.contextPath}/delete-teacher?id=${teacher.id}&firstname=${teacher.firstname}&lastname=${teacher.lastname}">Delete</a></td>
                    <td><a href="${pageContext.request.contextPath}/update-teacher?id=${teacher.id}&firstname=${teacher.firstname}&lastname=${teacher.lastname}">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div> 
    <c:if test="${deleteAPIError}">
        <p>Something went wrong in delete</p>
    </c:if>
</div>
<div> 
    <c:if test="${sqlError}">
        <p>Error in SQL update</p>
    </c:if>
</div>
</body>
</html>