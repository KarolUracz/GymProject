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
                    <c:if test="${pass.endDate gt now}"><a href="/user/extendPass/${user.user.id}/${pass.id}">Extend</a></c:if>
                    <c:if test="${pass.endDate lt now}"><a href="/user/buyPass/${user.user.id}">Buy</a></c:if>
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
<nav>
    <sec:authorize access="isAuthenticated()">
        <form action="<c:url value="/logout"/>" method="post">
            <input type="submit" value="Wyloguj">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </sec:authorize>
</nav>


</body>
</html>
