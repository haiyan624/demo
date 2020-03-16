<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>users</head>
    <body>
    <c:forEach items="$requestScope.users" var="user">
        ${user.id}--${user.name}--${user.password}--${user.salt}--${user.createDate}
    </c:forEach>
    </body>
</html>