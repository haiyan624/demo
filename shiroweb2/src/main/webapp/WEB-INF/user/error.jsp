<!-- 首页 xx.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>error 无权限</h2>
<!-- 重点在此：通过如下shiro标签显示 -->
<shiro:user>
    你好，<shiro:principal/> ，你没有权限登录此系统</a>
</shiro:user>
</body>
</html>