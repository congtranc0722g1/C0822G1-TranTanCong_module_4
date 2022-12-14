<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>convert</title>
</head>
<body>
<h1>Ứng Dụng Chuyển Đổi Tiền Tệ</h1>
<form action="/convert-usd-to-vnd" method="post">
    <label>
        <label>Nhập Số Tiền Cần chuyển (Đô La Mỹ)</label>
        <input type="text" name="usd">
    </label>
    <button type="submit">Chuyển</button>
</form>

<form action="/convert-vnd-to-usd" method="post">
    <label>
        <label>Nhập Số Tiền Cần chuyển (Việt Nam Đồng)</label>
        <input type="text" name="vnd">
    </label>
    <button type="submit">Chuyển</button>
</form>
<p>Kết Quả: ${result}</p>
</body>
</html>
