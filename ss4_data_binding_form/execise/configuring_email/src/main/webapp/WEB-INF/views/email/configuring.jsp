<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Configuring Email</title>
    <link rel="stylesheet" href="../../../bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<h1>Settings</h1>
<form:form action="/edit" method="post" modelAttribute="configuringEmail">
    <form:hidden path="id"/>
    <div class="row">
        <form:label class="col-lg-1" path="language">Languages</form:label>
        <form:select class="col-lg-3" path="language" items="${languageList}"/>
    </div>
    <div class="row">
        <form:label class="col-lg-1" path="pageSize">Page Size:</form:label>
        <div class="col-lg-3">
            <form:label path="pageSize">Show</form:label>
            <form:select path="pageSize" items="${pageSizeList}"/>
            <form:label path="pageSize">email per page</form:label>
        </div>
    </div>
    <div class="row">
        <form:label class="col-lg-1" path="spamFilter">Spam Filter</form:label>
        <form:checkbox class="col-lg-3" path="spamFilter"/>
    </div>
    <div class="row">
        <form:label class="col-lg-1" path="signature">Signature</form:label>
        <form:textarea class="col-lg-3" path="signature"/>
    </div>
    <button class="btn btn-primary" type="submit">Update</button>
    <button class="btn btn-secondary" type="reset">Cancel</button>
</form:form>
<script src="../../../bootstrap-5.1.3-dist/js/bootstrap.js"></script>
</body>
</html>
