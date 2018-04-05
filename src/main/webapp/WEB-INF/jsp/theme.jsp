<%@ page import="org.springframework.web.bind.annotation.SessionAttributes" %>
<%@ page import="ua.com.forum.domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>theme page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>

<%@include file="jspf/header.jspf" %>

<H5>Theme:</H5>
<div id="themes">
    <c:if test="${not empty selectedTheme}">
    <h3>${selectedTheme.title}<h3/>
</div>
<p id="theme_body">${selectedTheme.body}</p>
<ul class="list-group">
    <c:forEach items="${selectedTheme.commentsThemes}" var="comments">
        <li class="list-group-item">${comments.name}</li>
    </c:forEach>
</ul>
</c:if>
<form action="${pageContext.request.contextPath}/addComment">
    <div class="form-group">
        <input class="form-control" type="text" name="comment" id="customerEmail"
               placeholder="Add you comment" required/>
    </div>
    <div class="form-group">
        <input type="number" name="id" value="${selectedTheme.id}" hidden/>
    </div>
    <button type="submit">Add comment</button>
</form>

</body>
</html>
