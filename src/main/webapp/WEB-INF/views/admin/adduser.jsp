<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<form:form modelAttribute="user" method="post" action="/admin/addUser">
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
    <div>
        <label>Set role: <form:select path="roles" items="${roles}" itemLabel="name" itemValue="id"/></label>
    </div>
    <input type="submit" value="Confirm">
</form:form>
</body>
</html>
