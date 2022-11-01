<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<t:dashboard_layout title="Update Teacher" menu_name="Update Teacher">
<jsp:attribute name="form_area">
    <div>
        <form action="${pageContext.request.contextPath}/update-teacher" method="post">
            <input type="hidden" name="id" value="${teacher.id}"><br>
            <input type="text" name="firstname" value="${teacher.firstname}"><br>
            <input type="text" name="lastname" value="${teacher.lastname}"><br><br>
            <button type="submit">Update Teacher</button>
        </form>
    </div>
</jsp:attribute>
</t:dashboard_layout>