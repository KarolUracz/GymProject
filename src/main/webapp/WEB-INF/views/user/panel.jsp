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
<c:if test="${user.user.pass.size() > 0}">
    ${user.user.pass.size()}
    <table>
        <tr>
            <th>Pass type</th>
            <th>Pass valid till</th>
        </tr>
        <tr>
            <td><c:forEach items="${user.user.pass}" var="pass">
                ${pass.type} months
            </c:forEach> months
            </td>
        </tr>
    </table>
</c:if>
<c:if test="${user.user.pass.size() = 0}">
    <div>Buy gym pass:</div>
    <c:forEach items="${passes}" var="pass">
        ${pass.type} months <a href="/user/getPass/${pass.id}">Buy</a>
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
