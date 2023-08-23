
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker();
            $("#datepicker2").datepicker();

        });
    </script>
</head>
<body>
<h1 align="center">Car List</h1>
<div>
    <form:form method="post" modelAttribute="booking"  action="${pageContext.request.contextPath}/bookCar.htm">
    <div style="display: flex; justify-content: space-evenly" >
        <div>
    <label path="startDate" for="datepicker">Start Date</label>
        <form:input path="startDate" type="text" name="startDate" id="datepicker"/>
            <form:errors path="startDate"></form:errors>
        </div>
        <div>
        <label for="datepicker2">Return Date</label>
        <form:input path="returnDate" type="text" name="returnDate" id="datepicker2"/>
            <form:errors path="returnDate"></form:errors>
        </div>
    </div>
<table border="2" width="100%">
    <tr>
        <th>Select</th>
        <th>Company</th>
        <th>Model</th>
        <th>City</th>
        <th>Colour</th>
        <th>Price</th>


    </tr>
    <c:forEach var="c" items="${list}">
    <tr>
        <th><input  type="radio" name="check"  value="${c.licenseNo}"/></th>
        <th><c:out value="${c.company}"/></th>
        <th><c:out value="${c.model}"/></th>
        <th><c:out value="${c.city}"/></th>
        <th><c:out value="${c.colour}"/></th>
        <th><c:out value="${c.price}"/> </th>

    </tr>
    </c:forEach>

</div>

</table><br/>

    <input style="margin-left: 40%;" type="submit" value="submit"/>
    </form:form>

</div>


</body>
</html>
