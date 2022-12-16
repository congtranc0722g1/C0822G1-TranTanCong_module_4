<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Caculator</title>
    <link rel="stylesheet" href="../../../bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<h1 class="text-center">Caculator</h1>
<div class="row">
    <div class="col-lg-4"></div>
    <div class="col-lg-6">
        <form action="/calculate">
            <input type="text" name="first-number" placeholder="First Number" required>
            <input type="text" name="second-number" placeholder="Second Number" required>
            <br>
            <button type="submit" name="calculations" value="+">Addition[+]</button>
            <button type="submit" name="calculations" value="-">Subtraction[-]</button>
            <button type="submit" name="calculations" value="*">Multiplication[x]</button>
            <button type="submit" name="calculations" value="/">Division[/]</button>

        </form>
        <c:if test="${exception != null}">
            <p>${exception}</p>
        </c:if>
        <c:if test="${exception == null}">
            <p>${result}</p>
        </c:if>
    </div>
    <div class="col-lg-2"></div>
</div>
<script src="../../../bootstrap-5.1.3-dist/js/bootstrap.js"></script>
</body>
</html>
