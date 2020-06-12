<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/9/2020
  Time: 9:43 AM
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
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" href="/AdminHomePage.jsp">Trang chủ</a>
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
<h1 style="text-align: center">CHỈNH SỬA SẢN PHẨM THÀNH CÔNG</h1>
<div style="text-align: center">
    <div class="result-table" style="display: inline-block">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Mã Sản Phẩm</th>
                <th scope="col">Tên Sản Phẩm</th>
                <th scope="col">Giá Bán</th>
                <th scope="col">Tồn Kho</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">${wine.getId()}</th>
                <td>${wine.getName()}</td>
                <td>${wine.getPrice()}</td>
                <td>${wine.getStock()}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
