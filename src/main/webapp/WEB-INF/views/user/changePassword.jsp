<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-05-31
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password change</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <form:hidden path="id"/>
    <div>
        <label>Enter new password: <form:password path="password"/></label>
    </div>
    <input type="submit" value="Confirm">
</form:form>
</body>
</html>
