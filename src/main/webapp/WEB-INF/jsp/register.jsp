
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<jsp:include page="header.jsp" />--%>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div style="margin-left: 40%">
    <h1 style="margin-left: 20%">Caarz</h1>
    <h2 style="margin-left: 20%">Register</h2>
<form:form method="POST" modelAttribute="registerCustomer" cssStyle="border: thin; border: black">
    Email :<form:input path="email" type="text"/>
    <form:errors path="email"></form:errors><br/>

    Password: <form:input path="password" type="password"/>
    <form:errors path="password"></form:errors><br/>

    Name : <form:input path="name" type="text"/>
    <form:errors path="name"></form:errors><br/>

    Gender:
    Male<form:radiobutton path="gender" value="Male"/><br/>
    Female<form:radiobutton path="gender" value="Male"/><br/>
    Other<form:radiobutton path="gender" value="Other"/>
    <form:errors path="gender"></form:errors><br/>

    License: <form:input path="license" type="text"/>
    <form:errors path="license"></form:errors><br/>

    City:<form:input path="city" type="text"/>
    <form:errors path="city"></form:errors><br/>

    Category:<form:select path="category" name="category" id="category">
                <option value="carOwner"> CarOwner</option>
                <option value="customer"> Customer</option>
            </form:select><br/>

    <input style="margin-left: 20%" type="submit" value="Submit">
</form:form>

    <a style="margin-left: 20%" href="${pageContext.request.contextPath}/customer/login.htm">Login</a>

</div>


</body>
</html>
