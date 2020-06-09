<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/9/2020
  Time: 8:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm Kiếm Sản Phẩm</title>
</head>
<body>
    <h1>Tra cứu sản phẩm</h1>
    <form action="/selectProduct" method="post">
        <h3>Nhập tên hoặc mã sản phẩm</h3>
        <br>
        <br>
        <input type="text" name="keyword">
        <br>
        <button type="submit">Tìm Kiếm</button>
    </form>
</body>
</html>
