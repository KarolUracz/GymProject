<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User panel</title>
</head>
<body>
<p> You are logged as: ${user.user.firstName} <a href="/user/edit/${user.user.id}">Edit</a></p>
<nav>
    <sec:authorize access="isAuthenticated()">
        <form action="<c:url value="/logout"/>" method="post">
            <input type="submit" value="Wyloguj">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </sec:authorize>
</nav>
<c:if test="${user.user.passes.size() > 0}">
    <table>
        <tr>
            <th>Pass type</th>
            <th>Pass valid till</th>
        </tr>
        <tr>
            <c:forEach items="${user.user.passes}" var="pass">
                <td>${pass.passType.name} months</td>
                <td>${pass.endDate}</td>
                <td>
                    <c:if test="${pass.endDate gt now}"><a
                            href="/user/extendPass">Extend</a></c:if>
                    <c:if test="${pass.endDate lt now}">${user.user.passes.removeAll()}</c:if>
                </td>
            </c:forEach>
        </tr>
    </table>
</c:if>
<c:if test="${user.user.passes.size() == 0}">
    <div>Buy gym pass:</div>
    <c:forEach items="${passes}" var="pass">
        <p>${pass.name} <a href="/user/getPass/${pass.id}">Buy</a></p>
    </c:forEach>
</c:if>
<table>
    <tr>
        <th>Day</th>
        <th>Name</th>
        <th>Hour</th>
        <th>Trainer</th>
        <th>Action</th>
    </tr>
    <tr>
        <c:forEach items="${trainings}" var="training">
            <td>${training.dayOfWeek}</td>
            <td>training name</td>
            <td>${training.startHour}</td>
            <td>${training.trainer.username}</td>
            <td>
                    <c:if test="${training.participants.size() < 20}">
                        <a href="/user/participate/${user.user.id}/${training.id}">Participate</a>
                    </c:if>
                    <c:if test="${training.participants.size() >= 20}">
                        End of registration
                    </c:if>
            </td>
        </c:forEach>
    </tr>
</table>
<h4>You have signed for those trainings:</h4>
<c:forEach items="${userTrainings}" var="userTraining">
    ${userTraining.id} ${userTraining.dayOfWeek} ${userTraining.startHour} ${userTraining.trainer.username}
</c:forEach>

</body>
</html>
