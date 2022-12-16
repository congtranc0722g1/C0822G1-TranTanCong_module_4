
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
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
