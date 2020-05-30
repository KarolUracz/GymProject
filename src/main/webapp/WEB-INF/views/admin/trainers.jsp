<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-05-30
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trainers</title>
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
        <th>Actions</th>
    </tr>
    <c:forEach items="${trainers}" var="trainer">
        <tr>
            <td>${trainer.firstName}</td>
            <td>${trainer.lastName}</td>
            <td>${trainer.username}</td>
            <td><a href="/admin/addTraining/${trainer.id}"></a></td>
            <td><a href="/admin/details/${trainer.id}">Details</a></td>
            <td><a href="/admin/edit/${trainer.id}">Edit</a></td>
            <td><a href="/admin/delete/${trainer.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
