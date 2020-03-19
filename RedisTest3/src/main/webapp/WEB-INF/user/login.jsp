<!-- 登录页面 login.jsp 自动填充用户名 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<c:url value="/user/login/logic"/>" method="post">
    <!-- 重点在此：<shiro:principal/> -->
    username:<input type="text" name="username" value="<shiro:principal/>"> <br>
    password:<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>