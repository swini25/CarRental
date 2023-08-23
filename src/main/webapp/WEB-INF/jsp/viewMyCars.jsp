
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header2.jsp" />
<html>
<head>
    <title>View My Cars</title>
</head>
<body>

<h1 align="center"> My Car List</h1>
<div>
    <form:form method="post" modelAttribute="myCarList" action="${pageContext.request.contextPath}/viewMyCars.htm">

    <table border="2" width="100%">
        <tr>
            <th>Select</th>
            <th>Company</th>
            <th>Model</th>
            <th>License Number</th>
            <th>Colour</th>
            <th>Price</th>
        </tr>
        <c:forEach var="c" items="${myCarList}">
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
        <input type="submit" value="Delete Car"/>
        </form:form>


</div>

</body>
</html>
