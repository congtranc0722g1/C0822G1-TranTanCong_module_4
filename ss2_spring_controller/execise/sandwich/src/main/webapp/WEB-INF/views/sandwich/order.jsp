<%--
  Created by IntelliJ IDEA.
  User: cong
  Date: 12/15/2022
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/order" method="post">
    <label>
        <input type="checkbox" name="lettuce" value="lettuce">Lettuce
    </label>
    <label>
        <input type="checkbox" name="tomato" value="tomato">Tomato
    </label>
    <label>
        <input type="checkbox" name="mustard" value="mustard">Mustard
    </label>
    <label>
        <input type="checkbox" name="sprouts" value="sprouts">Sprouts
    </label>
    <button type="submit">Order</button>
</form>
</body>
</html>
