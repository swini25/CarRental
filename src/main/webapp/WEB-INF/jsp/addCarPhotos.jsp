
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header2.jsp" />
<html>
<head>
    <title>Add Car photos</title>
</head>
<body>
<h1 align="center"> My Car List</h1>
<div style="margin-left: 40%">
<%--    <form:form method="post" modelAttribute="photoCarList" enctype="multipart/form-data" action="${pageContext.request.contextPath}/addCarPhoto.htm">--%>
    <form:form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/addCarPhoto.htm">

        <table>
            <tr>
                <th>Select</th>
                <th>Company</th>
                <th>Model</th>
                <th>License Number</th>
                <th>Colour</th>
                <th>Price</th>
            </tr>
            <c:forEach var="c" items="${photoCarList}">
                <tr>
                    <th><input type="radio" name="check" name value="${c.licenseNo}"></th>
                    <th><c:out value="${c.company}"/></th>
                    <th><c:out value="${c.model}"/></th>
                    <th><c:out value="${c.licenseNo}"/></th>
                    <th><c:out value="${c.colour}"/></th>
                    <th><c:out value="${c.price}"/></th>
                </tr>
            </c:forEach>
        </table>
        <label for="carImage">Upload Image</label>
        <input type="file" name="carImage"  id="carImage" required/>
        <input type="submit" value="Upload Image" name="uploadImage"/>
    </form:form>

</div>
</body>
</html>
