<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp" />
<h4>Перейти к:</h4>
<ol>
    <li><a href="hello-servlet">Преподаватели</a></li>
    <li><a href="subjects">Дисциплины</a></li>
</ol>
<br/>
<jsp:include page="footer.jsp" />
</body>
</html>