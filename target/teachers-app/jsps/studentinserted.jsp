<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student inserted successfully</title>
</head>
<body>
    <h2>Student inserted successfully</h2>
    <div>
        <p>${insertedStudent.lastname}</p>
        <p>${insertedStudent.firstname}</p>
    </div>

    <div>
        <a href="${pageContext.request.contextPath}/jsps/menu.jsp">Return to students menu</a>
    </div>

</body>
</html>