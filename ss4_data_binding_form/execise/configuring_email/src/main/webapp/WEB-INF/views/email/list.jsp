<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="../../../bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<h5 class="text-danger">${mess}</h5>
<table class="table table-striped">
    <tr>
        <th>Languages</th>
        <th>Page Size</th>
        <th>Spam Filter</th>
        <th>Signature</th>
        <th>Edit</th>
    </tr>
    <tr>
        <c:forEach var="configuringEmail" items="${configuringEmailList}">
    <tr>
        <td>${configuringEmail.getLanguage()}</td>
        <td>${configuringEmail.getPageSize()}</td>
        <td>${configuringEmail.isSpamFilter()}</td>
        <td>${configuringEmail.getSignature()}</td>
        <td><a href="/edit/${configuringEmail.id}">
            <button class="btn btn-primary">Edit</button>
        </a></td>
    </tr>
    </c:forEach>
    </tr>
</table>
<script src="../../../bootstrap-5.1.3-dist/js/bootstrap.js"></script>
</body>
</html>
