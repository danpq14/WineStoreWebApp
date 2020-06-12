<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/11/2020
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Kết quả tìm kiếm sản phẩm</title>
    <link rel="stylesheet"href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <style>
        .result-table {
            width: auto;
            display: inline-block;
        }
    </style>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" href="/homePage">Trang chủ</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/customerAction?action=showAllProduct">Danh sách tất cả các sản phẩm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/topProduct">Top sản phẩm bán chạy</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/searchProduct">Tìm Kiếm Sản Phẩm</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/topCustomer">Giỏ Hàng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/topCustomer">Thông tin cá nhân</a>
    </li>
</ul>
<h1 style="text-align: center">Danh sách sản phẩm bán chạy</h1>
<div>
    <div style="text-align: center">
        <div class="result-table">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Mã Sản Phẩm</th>
                    <th scope="col">Tên Sản Phẩm</th>
                    <th scope="col">Giá Bán</th>
                    <th scope="col">Tồn Kho</th>
                    <th colspan="3">Tùy Chỉnh</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${wines}" var="wine">
                    <tr>
                        <th scope="row">${wine.getId()}</th>
                        <td>${wine.getName()}</td>
                        <td>${wine.getPrice()}</td>
                        <td>${wine.getStock()}</td>
                        <td><a href="/addToCart?id=${wine.getId()}" target="_blank">Thêm vào giỏ hàng</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
</html>
