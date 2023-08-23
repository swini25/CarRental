
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header Car Owner</title>
</head>
<body>
<div class="header" style="height: 4%; width: 100%" >
    <h1 align="center" style="text-decoration-color: #e51218">Caarz</h1>
</div>
<div class="navBar" style="display: flex; justify-content: space-evenly; height: 20px; width: 100%; margin-top: 2%; background-color: #a5cbe9">
<%--    <a href="${pageContext.request.contextPath}/register.htm">Register</a>--%>

<%--    <a href="${pageContext.request.contextPath}/customer/login.htm">Login</a>--%>
    <a href="${pageContext.request.contextPath}/uploadLicense.htm">Upload Document</a>
    <a href="${pageContext.request.contextPath}/addCar.htm">AddCar</a>
<%--    <a href="${pageContext.request.contextPath}/addCarPhoto.htm">Add Car Image</a>--%>
    <a href="${pageContext.request.contextPath}/viewMyCars.htm">View My Cars</a>
    <a href="${pageContext.request.contextPath}/updateMyCar.htm">Update Car</a>
    <a href="${pageContext.request.contextPath}/Customer/logout.htm">LogOut</a>
</div>
</body>
</html>
