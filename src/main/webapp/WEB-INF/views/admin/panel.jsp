<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <th>Actions</th>
    </tr>
<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.username}</td>
        <td><c:forEach items="${user.roles}" var="role">${role.name}</c:forEach></td>
        <td><a href="/admin/edit/${user.id}">Edit</a></td>
        <td><a href="/admin/delete/${user.id}">Delete</a></td>
    </tr>
</c:forEach>
</table>
<p><a href="/admin/addPass">Add pass</a></p>
<table>
    <tr>
        <th>Pass type</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${passes}" var="pass">
        <tr>
            <td>${pass.type} months</td>
            <td><a href="/admin/passDelete/${pass.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="/admin/addUser">Add user</a></p>
<p><a href="/admin/addAdmin">Add admin</a></p>
<p><a href="/admin/addTrainer">Add trainer</a></p>
</body>
</html>
