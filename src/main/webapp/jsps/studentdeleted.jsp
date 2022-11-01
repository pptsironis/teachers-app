<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Deleted</title>
</head>
<body>
    <p>
        Student: ${student.id} ${student.firstname} ${student.lastname} was deleted
    </p>
    <a href="${pageContext.request.contextPath}/jsps/studentmenu.jsp">Return to students menu</a>

</body>
</html>