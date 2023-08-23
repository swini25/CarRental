
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header2.jsp" />
<html>
<head>
    <title>No Cars to Display</title>
</head>
<body>
<div style="margin-left: 40%">
<h2>You Have No Cars Registered With Us</h2>

<h4 style="margin-left: 20%">Click here to Add Your Car</h4>
<a style="margin-left: 25%"href="${pageContext.request.contextPath}/addCar.htm">AddCar</a>
</div>
</body>
</html>
