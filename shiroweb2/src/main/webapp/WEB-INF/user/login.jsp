<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>login</title>
</head>

<body>
<shiro:authenticated>
    欢迎您，<shiro:principal/>
</shiro:authenticated>

<shiro:user> <!-- 常用，包含已登录 且配合记住我，用户体验好 -->
    欢迎您,<shiro:principal/>
</shiro:user>

<shiro:guest>
    欢迎您，未登录，请<a href="<c:url value="/user/login/page"/>">登录</a>
</shiro:guest>

<shiro:notAuthenticated>
    您尚未登录(记住我也算在未登录中)
</shiro:notAuthenticated>

</body>
</html>
