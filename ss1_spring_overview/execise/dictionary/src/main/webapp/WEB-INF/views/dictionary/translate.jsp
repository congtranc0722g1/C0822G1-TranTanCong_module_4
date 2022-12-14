<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>translate</title>
</head>
<body>
<form action="/translate" method="get">
    <label>
        <label>Nhập từ cần dịch</label>
        <input type="text" name="keyWord" placeholder="Nhập từ cần dịch">
    </label>
    <button type="submit">Dịch</button>
</form>

<p>Kết Quả: ${result}</p>
</body>
</html>
