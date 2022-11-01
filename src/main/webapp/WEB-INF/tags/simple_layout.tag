<!DOCTYPE html>
<%@tag description="Simple Template" pageEncoding="UTF-8"%>
 
<%@attribute name="title" required="true"%>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="body_area" fragment="true" %>
 
<html>
 <head>
 <meta charset="UTF-8">
 <title>${title}</title>
     <jsp:invoke fragment="head_area"/>
 </head>
 <body>
     <jsp:invoke fragment="body_area"/>
 </body>
</html>