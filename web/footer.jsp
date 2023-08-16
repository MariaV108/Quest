<%--
  Created by IntelliJ IDEA.
  User: mariavorobeva
  Date: 15.08.2023
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Footer</title>
</head>
<body>
<h2>Statistics:</h2>
<h4>Name: <%= session.getAttribute("name") %></h4>
<h4>Age: <%= session.getAttribute("playerAge") %></h4>
<h4>Id: <%= session.getAttribute("id") %></h4>


</body>
</html>
