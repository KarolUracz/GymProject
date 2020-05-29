<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-05-28
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User edition</title>
</head>
<body>
<form:form method="post" action="/admin/edit" modelAttribute="user">
    <form:hidden path="id"/>
    <form:hidden path="username"/>
        <div>
        <label>Enter Your name: <form:input path="firstName"/></label>
        <form:errors path="firstName"/>
    </div>
    <div>
        <label>Enter Your surname: <form:input path="lastName"/></label>
        <form:errors path="lastName"/>
    </div>
    <div>
        <label>Enter Your address: <form:input path="address"/></label>
        <form:errors path="address"/>
    </div>
    <input type="submit" value="Confirm">
</form:form>
</body>
</html>
