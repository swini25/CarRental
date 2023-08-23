
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="header.jsp" />--%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>


<div >
    <h1 align="center">Caarz</h1>
    <div>
        <h3 style="z-index: 4" align="center">Drive your Dream car!</h3>
        <h4 style="z-index: 4" align="center">Login to book a car</h4>
        <a style="margin-left: 50%; z-index: 4" href="${pageContext.request.contextPath}/customer/login.htm">Login</a>
    <img src="<%=request.getContextPath()%>/images/img1.jpg" alt="background image" style="width:100%; height: 100%; z-index: -1; position: relative">
    </div>

</div>
</body>
</html>
