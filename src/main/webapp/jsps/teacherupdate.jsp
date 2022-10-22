<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Teacher</title>
</head>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/update" method="post">
            <input type="hidden" name="id" value="${teacher.id}"><br>
            <input type="text" name="firstname" value="${teacher.firstname}"><br>
            <input type="text" name="lastname" value="${teacher.lastname}"><br><br>
            <button type="submit">Update Teacher</button>
        </form>
    </div>
</body>
</html>