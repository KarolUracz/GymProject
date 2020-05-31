<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Extend pass</title>
</head>
<body>
<div>Buy gym pass:</div>
<c:forEach items="${passExtend}" var="pass">
    <p>${pass.name} <a href="/user/extendPass/${pass.id}">Buy</a></p>
</c:forEach>
</body>
</html>
