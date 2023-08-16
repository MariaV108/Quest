<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
</head>
<body>
<h1>
    <%= request.getAttribute("questionNumber") %>
</h1>

<% if (request.getAttribute("isRight1").equals("true")) { %>
<button onclick="location.href='/question?id=<%= request.getAttribute("nextQuestionId") %>'">
    <%= request.getAttribute("answer1") %>
</button>
<% } else { %>
<button onclick="location.href='/wrongAnswer?id=<%= request.getAttribute("currentQuestionId") %>'">
    <%= request.getAttribute("answer1") %>
</button>
<% } %>
<% if (request.getAttribute("isRight2").equals("true")) { %>
<button onclick="location.href='/question?id=<%= request.getAttribute("nextQuestionId") %>'">
    <%= request.getAttribute("answer2") %>
</button>
<% } else { %>
<button onclick="location.href='/wrongAnswer?id=<%= request.getAttribute("currentQuestionId") %>'">
    <%= request.getAttribute("answer2") %>
</button>
<% } %>

<%@ include file="footer.jsp"%>
</body>
</html>
