<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<h1 align="center">Caarz</h1>
<h2 align="center">LogIn</h2>
<div style="margin-left:40%">
    <form:form method="POST" modelAttribute="customer" cssStyle="border: thin; border: black">
    <div>
        UserEmail:<form:input path="email" type="text"/>
        <form:errors path="email"></form:errors>
    </div>
        <br/>
    <div>
        Password:<form:input path="password" type="password" name="password"/>
        <form:errors path="password"></form:errors>
    </div>
        <br/>
    <div>
        Category:<form:select path="category" name="category" id="category">
                <option value="carOwner"> CarOwner</option>
                <option value="customer"> Customer</option>
                </form:select>
        <form:errors path="category"></form:errors>
    </div>
        <br/>
    <input type="submit" value="Submit"/> <br/><br/>
    </form:form>

    Don't have an account? <a href="${pageContext.request.contextPath}/register.htm">Register</a>

</div>
</body>
</html>


