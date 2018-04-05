<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>registration page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>

<%@include file="jspf/header.jspf" %>

<form name="customerData" id="customerData" action="${pageContext.request.contextPath}/registrations" method="post">
    <div class="form-group">
        <h4>Registration Form:</h4>
    </div>
    <div class="form-group">
        <input class="form-control" type="text" name="name" id="customerName"
               placeholder="Enter your name" required minlength="3"/>
    </div>
    <div class="form-group">
        <input class="form-control" type="text" name="nick" id="customerNick"
               placeholder="Enter your nickname" required minlength="3"/>
    </div>
    <div class="form-group">
        <input class="form-control" type="email" name="email" id="customerEmail"
               placeholder="Enter your e-mail" required/>
    </div>
    <div class="form-group">
        <input class="form-control" type="password" name="password" id="customerPassword"
               placeholder="Enter your password" required/>
    </div>
    <div class="form-group">
        <input class="form-control" type="number" name="age" id="customerAge"
               placeholder="Enter your age" required minlength="2"/>
    </div>
    <div class="form-group">
        <input type="submit" class="btn btn-default" value="Registration" id="regBtn">
    </div>
</form>

</body>
</html>
