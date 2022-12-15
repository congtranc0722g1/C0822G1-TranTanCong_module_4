<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>The condiments that go with the sandwich</h1>
<c:if test="${lettuce != null}">
    <p>${lettuce}</p>
</c:if>
<c:if test="${tomato != null}">
    <p>${tomato}</p>
</c:if>
<c:if test="${mustard != null}">
    <p>${mustard}</p>
</c:if>
<c:if test="${sprouts != null}">
    <p>${sprouts}</p>
</c:if>
</body>
</html>
