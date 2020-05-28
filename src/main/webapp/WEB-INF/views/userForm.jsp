<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User form</title>
</head>
<body>
<form:form method="post" action="/user/form" modelAttribute="user">
    <form:hidden path="id"/>
    <div>
        <label>Enter Your email: <form:input path="username"/></label>
        <form:errors path="username"/>
    </div>
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
    <div>
        <label>Set Your password: <form:password path="password"/></label>
        <form:errors path="password"/>
    </div>
    <input type="submit" value="Confirm">
</form:form>
</body>
</html>
