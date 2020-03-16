<%--
  Created by IntelliJ IDEA.
  User: ZY
  Date: 2020/3/14
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>regist</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/regist" method="post">
    username:<input type="text" name="name"/><br/>
    password:<input type="text" name="password"/><br/>
    <input type="submit" value="注册">
</form>
</body>
</html>

