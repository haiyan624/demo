<%--
  Created by IntelliJ IDEA.
  User: Mickey
  Date: 2020/3/17
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>operation</td>
    </tr>
    <tr>
        <td>001</td>
        <td>张三</td>
        <td>
            <shiro:hasAnyRoles name="admin,manager">
                <a href="#" style="text-decoration:none">详情</a>
            </shiro:hasAnyRoles>
            <shiro:hasRole name="admin">
                <a href="#" style="text-decoration: none">删除</a>
            </shiro:hasRole>
            <shiro:lacksRole name="admin">
                <a href="#" style="text-decoration: none">点击升级</a>
            </shiro:lacksRole>
        </td>
    </tr>
</table>

</body>
</html>
