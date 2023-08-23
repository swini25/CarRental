
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<html>
<head>
    <title>My Bookings</title>
</head>
<body>
<div >
    <table border="2" width="100%">
        <tr>
            <th>Car License Number</th>
            <th>Start Date</th>
            <th>Return Date</th>
            <th>Price Per Day</th>
            <th>Total Bill</th>
        </tr>
        <c:forEach var="c" items="${bookingList}">
            <tr>

                <th><c:out value="${c.carLicenseNo}"/></th>
                <th><c:out value="${c.startDate}"/></th>
                <th><c:out value="${c.returnDate}"/></th>
                <th><c:out value="${c.price}"/></th>
                <th><c:out value="${c.totalPrice}"/></th>
            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>
