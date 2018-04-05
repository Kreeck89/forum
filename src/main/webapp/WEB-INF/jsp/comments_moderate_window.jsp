<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>comments moderate</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>

<%@include file="jspf/header.jspf"%>

<c:if test="${not empty comment}">
<form name="customerData" class="moderateDate" action="${pageContext.request.contextPath}/change_comment"
      method="post">
    <div class="form-group">
        <h4>Moderates selected comment to theme:</h4>
    </div>
    <div class="form-group">
        <a>comment id</a>
        <input class="form-control" type="number" name="id" value="${comment.id}"/>
    </div>
    <div class="form-group">
        <a>comment title</a>
        <input class="form-control" type="text" name="comment" value="${comment.name}"/>
    </div>
    <div class="form-group">
        <input type="submit" class="btn btn-default" value="Update" id="saveBtn">
    </div>
</form>
    <form action="${pageContext.request.contextPath}/delete_comment" class="moderateDate">
        <div class="form-group">
            <input type="number" name="id" value="${comment.id}" hidden>
            <input type="submit" class="btn btn-default" value="Delete" id="delBtn">
        </div>
    </form>
    </form>
    <form action="${pageContext.request.contextPath}/back_comment" class="moderateDate">
        <div class="form-group">
            <input type="submit" class="btn btn-default" value="Back" id="backBtn">
        </div>
    </form>
</c:if>

</body>
</html>
