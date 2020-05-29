<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Raider
  Date: 2020-05-28
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pass add</title>
</head>
<body>
<form:form modelAttribute="passType" method="post" action="/admin/addPass">
    <form:hidden path="id"/>
    <div>
        <label>Enter name: <form:input path="name"/></label>
    </div>
    <div>
        <label>Enter period in months: <form:input path="period"/></label>
    </div>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
