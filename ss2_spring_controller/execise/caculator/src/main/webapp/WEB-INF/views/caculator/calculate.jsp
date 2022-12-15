<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>
   <form action="/calculate">
       <label>First Number</label>
       <input type="text" name="first-number" placeholder="First Number">
       <select name="calculations">
           <option value="+">Addition</option>
           <option value="-">Subtraction</option>
           <option value="*">Multiplication</option>
           <option value="/">Division</option>
       </select>
       <label>Second Number</label>
       <input type="text" name="second-number" placeholder="Second Number">
       <button type="submit">Start</button>
   </form>
<h3>Kết Quả: ${result}</h3>
</body>
</html>
