<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>choose theme</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>

<%@include file="jspf/header.jspf"%>

<div align="left" style="width: 100%">
    <h3 align="center" style="color: saddlebrown">Themes For Moderate:</h3>
    <div class="list-group" align="center">
        <c:if test="${not empty allThemes}">
            <c:forEach items="${allThemes}" var="elem">
                <a href="${pageContext.request.contextPath}/theme_id?id=${elem.id}"
                   class="list-group-item list-group-item-action">${elem.title}</a>
            </c:forEach>
        </c:if>
    </div>
</div>

</body>
</html>
