<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Training add</title>
</head>
<body>
<form:form method="post" modelAttribute="training">
    <form:hidden path="id"/>

    <div>
        <label>Choose trainer: </label>
        <form:select path="trainer" items="${trainers}" itemLabel="username" itemValue="id"/>
    </div>
    <div>
        <label>Choose day of week: <form:select path="dayOfWeek" items="${days}"/></label>
    </div>
    <div>
        <label>Enter start hour: <form:input path="startHour"/></label>
    </div>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
