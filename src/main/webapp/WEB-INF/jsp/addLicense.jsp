
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload License</title>
</head>
<body>

<form method="post" modelAttribute="license"  enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadLicense.htm">
    <label for="licenseDoc">Upload License</label>
    <input type="file" name="licenseDoc"  id="licenseDoc" required/>
    <input type="submit" value="Upload Document" name="licenseDoc"/>
</form>
</body>
</html>
