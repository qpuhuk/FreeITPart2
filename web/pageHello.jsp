
<%@ page contentType="text/html;charset=UTF-8" %>
<% String name = request.getParameter("username"); %>
<html>
<head>
    <meta charset="UTF-8">
    <meta lang="eng">
    <title>Welcome</title>
</head>
<body>
<h1><%= "Hello, " + name %>
</h1>
</body>
</html>
