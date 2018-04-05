<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>selected theme</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>

<%@include file="jspf/header.jspf" %>

<c:if test="${not empty selectedTheme}">
    <form name="customerData" class="moderateDate" action="${pageContext.request.contextPath}/change_theme"
          method="post">
        <div class="form-group">
            <h4>Moderates selected theme:</h4>
        </div>
        <div class="form-group">
            <a>theme id</a>
            <input class="form-control" type="number" name="id" id="themesId"
                   value="${selectedTheme.id}"/>
        </div>
        <div class="form-group">
            <a>theme title</a>
            <input class="form-control" type="text" name="title" id="themesTitle"
                   value="${selectedTheme.title}"/>
        </div>
        <div class="form-group">
            <a>about title text</a>
            <input class="form-control" type="text" name="body" id="themesBody"
                   value="${selectedTheme.body}"/>
        </div>

        <div align="left" style="width: 100%">
            <h3 align="center" style="color: antiquewhite">comments:</h3>
            <div class="list-group" align="center">
                <c:if test="${not empty selectedTheme.commentsThemes}">
                    <c:forEach items="${selectedTheme.commentsThemes}" var="elem">
                        <a href="${pageContext.request.contextPath}/moder_comment?id=${elem.id}"
                           class="list-group-item list-group-item-action">${elem.name}</a>
                    </c:forEach>
                </c:if>
            </div>
        </div>

        <div class="form-group">
            <input type="submit" class="btn btn-default" value="Update" id="saveBtn">
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/delete_theme" class="moderateDate">
        <div class="form-group">
            <input type="number" name="id" value="${selectedTheme.id}" hidden/>
            <input type="submit" class="btn btn-default" value="Delete" id="delBtn">
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/back_theme" class="moderateDate">
        <div class="form-group">
            <input type="submit" class="btn btn-default" value="Back" id="backBtn">
        </div>
    </form>
</c:if>

</body>
</html>
