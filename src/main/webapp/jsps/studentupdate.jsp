<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/update-student" method="post">
            <input type="hidden" name="id" value="${student.id}"><br>
            <input type="text" name="firstname" value="${student.firstname}"><br>
            <input type="text" name="lastname" value="${student.lastname}"><br><br>
            <button type="submit">Update Student</button>
        </form>
    </div>
</body>
</html>