
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WrongAnswer</title>
</head>
<body>
<h1><%= request.getAttribute("wrongAnswer") %></h1>
<div>
    <button onclick="location.href='/'">Start again!</button>
</div>
</body>
</html>
