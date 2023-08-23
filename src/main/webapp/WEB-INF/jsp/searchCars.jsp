
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<html>
<head>
    <title>Search Cars</title>
</head>
<body>

<div style="margin-left: 40%">

<form:form method="get" modelAttribute="bookingCars" action="${pageContext.request.contextPath}/searchCar.htm" >

    <select name="city" id="city">
        <option value="Boston">Boston</option>
        <option value="Texas">Texas</option>
        <option value="New York">New York</option>
        <option value="Arizona">Arizona</option>
        <option value="California">California</option>
        <option value="Seattle">Seattle</option>
        <option value="Miami">Miami</option>
    </select><br/><br/>

    <input style="margin-left: 20%" type="submit" value="Search">
</form:form>

</div>
</body>
</html>
