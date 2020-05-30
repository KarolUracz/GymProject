<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-05-30
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Trainings</title>
</head>
<body>
<table>
    <tr>
        <th>Day</th>
        <th>Starting hour</th>
        <th>Trainer</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${trainings}" var="training">
        <tr>
            <td>${training.dayOfWeek}</td>
            <td>${training.startHour}</td>
            <td>${training.trainer.username}</td>
            <td>
                <a href="/admin/deleteTraining/${training.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
