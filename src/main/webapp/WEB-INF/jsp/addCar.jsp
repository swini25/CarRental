
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header2.jsp" />
<html>
<head>
    <title>Add Car</title>
</head>
<body>
<h1 style="margin-left: 30%"> ADD Your Car and be OUR PARTNER</h1>
<div style="margin-left: 40%" >
    <form:form method="post" modelAttribute="car"  action="${pageContext.request.contextPath}/addCar.htm">

        Company: <form:select path="company" name="company" id="company">
        <option value="Dodge"> DODGE</option>
        <option value="HONDA"> HONDA</option>
        <option value="BMW"> BMW</option>
        <option value="JEEP"> JEEP</option>
        <option value="MERCEDES"> MERCEDES</option>
        <option value="TOYOTA"> TOYOTA</option>
        <option value="Audi">Audi</option>
        <option value="Chevrolet">Chevrolet</option>
    </form:select><br/><br/>
        Model : <form:input path="model" name="model" type="text"></form:input>
                <form:errors path="model"></form:errors><br/><br/>

        Make Year:<form:input path="makeYear" name="makeYear" type="text"></form:input>
                    <form:errors path="makeYear"></form:errors><br/><br/>

        City: <form:select path="city" name="city" >
                    <option value="Boston">Boston</option>
                    <option value="Texas">Texas</option>
                    <option value="New York">New York</option>
                    <option value="Arizona">Arizona</option>
                    <option value="California">California</option>
                    <option value="Seattle">Seattle</option>
                    <option value="Miami">Miami</option>
                </form:select></br><br/>

        License No:<form:input path="licenseNo" name="licenseNo" type="text"></form:input>
                    <form:errors path="licenseNo"></form:errors><br/><br/>

        Colour: <form:input path="colour" name="colour" type="text"></form:input>
                <form:errors path="colour"></form:errors><br/><br/>

        Price: <form:input path="price" name="price" type="text"></form:input>
                <form:errors path="price"></form:errors><br/><br/>

        <input style="margin-left: 20%" type="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>
