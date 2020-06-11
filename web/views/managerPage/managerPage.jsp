<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/8/2020
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<%--    <ul> Sản phẩm--%>
<%--        <li><a href="/AllProduct">Hiển thị tất cả sản phẩm</a></li>--%>
<%--        <li><a href="/selectProduct">Tra cứu sản phẩm</a></li>--%>
<%--        <li><a href="">Thêm mới sản phẩm</a></li>--%>
<%--        <li><a href="">Chỉnh sửa sản phẩm</a></li>--%>
<%--        <li><a href="">Xóa Sản Phẩm</a></li>--%>
<%--    </ul>--%>

<%--    <ul> Khách hàng--%>
<%--        <li><a href="">Hiển thị danh sách khách hàng</a></li>--%>
<%--        <li><a href="">Thêm mới khách hàng</a></li>--%>
<%--        <li><a href="">Chỉnh sửa khách hàng</a></li>--%>
<%--        <li><a href="">Tra cứu khách hàng</a></li>--%>
<%--    </ul>--%>

<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" href="#">Trang chủ</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/AllProduct">Danh sách sản phẩm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/selectProduct">Tra cứu sản phẩm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/addProduct">Thêm mới sản phẩm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/customerList">Danh sách khách hàng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/customerSearch">Tra cứu khách hàng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/searchOrder">Tra cứu hóa đơn</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/revenue">Theo dõi doanh thu</a>
    </li>
</ul>
</body>
</html>
