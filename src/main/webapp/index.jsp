<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<% String name = request.getParameter("name");%>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello " + name %>
</h1>
<br/>
<a href="one">Welcome</a>
</body>
</html>