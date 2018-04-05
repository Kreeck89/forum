<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add new theme</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>

<%@include file="jspf/header.jspf" %>

<h3>Add Your New Theme:</h3>
<form action="${pageContext.request.contextPath}/save_new_theme">
    <div class="form-group">
        <input class="form-control" type="text" name="title" placeholder="Title" required minlength="5"/>
    </div>
    <div class="form-group">
        <input class="form-control" type="text" name="body" placeholder="Body" required minlength="50"/>
    </div>
    <button type="submit">Save</button>
</form>

</body>
</html>
