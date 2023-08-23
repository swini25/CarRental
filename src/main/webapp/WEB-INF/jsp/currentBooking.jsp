
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<html>
<head>
    <title>Current Booking</title>
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

<h1 align="center">Modify Your Current Booking</h1>

<div style="margin-left: 30%; margin-top: 10%">
    <form:form method="post" modelAttribute="bookingDetails" action="${pageContext.request.contextPath}/modifyMyBooking.htm">
        <div style="display: flex; justify-content: space-evenly">

            <div>
                <input type="radio" name="check" name value="${bookingDetails.bookingId}">
            </div>
            <div>

                <label>License No:</label>
                <input type="text"  name="licenseNumber" value="${bookingDetails.carLicenseNo}" readonly>

            </div>
            <div>
                <label path="startDate" for="datepicker">Start Date</label>
                <form:input path="startDate" value= "${bookingDetails.startDate}" type="text" name="startDate" id="datepicker"/>

            </div>
            <div>
                <label for="datepicker2">Return Date</label>
                <form:input path="returnDate" value= "${bookingDetails.returnDate}" type="text" name="returnDate" id="datepicker2"/>
            </div>
            <div>
                <label>Price Per Day:</label>
                <input type="text"  name="total Bill" value="${bookingDetails.price}" readonly>
            </div>


        </div>

        <input style="margin-left: 40%" type="submit" value="Modify"/>
    </form:form>
    </table>
</div>

</body>
</html>
