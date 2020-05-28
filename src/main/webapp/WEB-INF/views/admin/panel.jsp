<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-05-28
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
</head>
<body>
<nav>
    <sec:authorize access="isAuthenticated()">
        <form action="<c:url value="/logout"/>" method="post">
            <input type="submit" value="Wyloguj">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </sec:authorize>
</nav>
<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Username/email</th>
        <th>Roles</th>
    </tr>
<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.username}</td>
        <td><c:forEach items="${user.roles}" var="role">${role.name}</c:forEach></td>
    </tr>
</c:forEach>
</table>
<div><a href="/admin/addUser">Add user</a></div>
</body>
</html>
