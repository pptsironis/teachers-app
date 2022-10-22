<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher inserted successfully</title>
</head>
<body>
    <h2>Teacher inserted successfully</h2>
    <div>
        <p>${insertedTeacher.lastname}</p>
        <p>${insertedTeacher.firstname}</p>
    </div>

    <div>
        <a href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp">Return to teachers menu</a>
    </div>

</body>
</html>