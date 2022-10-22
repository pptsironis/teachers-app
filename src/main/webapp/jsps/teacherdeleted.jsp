<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Deleted</title>
</head>
<body>
    <p>
        Teacher: ${teacher.id} ${teacher.firstname} ${teacher.lastname} was deleted
    </p>
    <a href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp">Return to teachers menu</a>

</body>
</html>