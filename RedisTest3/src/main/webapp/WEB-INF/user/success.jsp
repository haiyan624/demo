<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>success</title>
</head>

<body>
<shiro:authenticated>
    欢迎您(authenticated)，<shiro:principal/>
</shiro:authenticated>
<br/>
<shiro:user> <!-- 常用，包含已登录 且配合记住我，用户体验好 -->
    欢迎您(user),<shiro:principal/>
</shiro:user>
<br/>
<shiro:guest>
    欢迎您（guest），未登录，请<a href="<c:url value="/user/login/page"/>">登录</a>
</shiro:guest>
<br/>
<shiro:notAuthenticated>
    您尚未登录(记住我也算在未登录中notAuthenticated)
</shiro:notAuthenticated>
<br/>
</body>
</html>
