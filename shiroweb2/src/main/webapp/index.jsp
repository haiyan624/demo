<!-- 首页 xx.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World! </h2>
<!-- 重点在此：通过如下shiro标签显示 -->
<shiro:user>
    欢迎您，<shiro:principal/> <a href="<c:url value="/user/logout"/>">退出登录</a>
</shiro:user>
</body>
</html>