
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<html>
<head>
    <title>Return Car</title>
</head>
<body>

<div style="margin-left: 30%; margin-top: 10%">
    <form:form method="post" modelAttribute="bookingDetails" action="${pageContext.request.contextPath}/returnCar.htm">
    <div style="display: flex; justify-content: space-evenly">

        <div>
            <input type="radio" name="check" name value="${bookingDetails.bookingId}">
        </div>
        <div>

            <label>License No:</label>
            <input type="text"  name="licenseNumber" value="${bookingDetails.carLicenseNo}" readonly>

        </div>
        <div>
            <label>Start Date:</label>
            <input type="text"  name="startDate" value="${bookingDetails.startDate}" readonly>

        </div>
        <div>
            <label>Return Date:</label>
            <input type="text"  name="returnDate" value="${bookingDetails.returnDate}" readonly>
        </div>
        <div>
            <label>Total Bill:</label>
            <input type="text"  name="total Bill" value="${bookingDetails.totalPrice}" readonly>
        </div>


    </div>

        <input style="margin-left: 40%" type="submit" value="Pay & Return"/>
        </form:form>
    </table>
</div>

</body>
</html>
