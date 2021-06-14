
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta lang="eng">
    <title>Welcome</title>
</head>
<body>
<h1><%= "Hello, " + session.getAttribute("name") %>
</h1>
<form action="index.html" method="Post">
<input type="submit" value="Logout"/>
    <%session.invalidate();%>
</form>
</body>
</html>
