<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p> You are logged as: ${user.user.firstName}</p>

<table>
    <tr>
        <th>Pass type</th>
        <th>Pass valid till</th>
    </tr>
    <tr>
        <td>${user.user.pass.type} months</td>
        <td>${user.user.pass.endDate}</td>
    </tr>
</table>
<div>Buy gym pass:</div>
<c:forEach items="${passes}" var="pass">
    ${pass.type} months <a href="/user/getPass/${pass.id}">Buy</a>
</c:forEach>
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
