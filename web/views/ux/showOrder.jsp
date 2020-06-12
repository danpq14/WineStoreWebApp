<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chỉnh sửa thông tin khách hàng</title>
    <link rel="stylesheet"href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

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
<h1 style="text-align: center">THÔNG TIN GIỎ HÀNG</h1>
    <div style="text-align: center">
        <div style="display: inline-block">
            <h4>Mã khách hàng : ${customer.getId()}</h4>
            <h4>Tên khách hàng : ${customer.getName()}</h4>
        </div>
    </div>
    <div style="text-align: center">
        <div class="result-table" style="display: inline-block">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Thứ tự</th>
                    <th scope="col">Mã sản phẩm</th>
                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Thành Tiền</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${currentList}" var="wine" varStatus="loop">
                    <tr>
                        <td>${loop.index +1}</td>
                        <td>${wine.getWineId()}</td>
                        <td>${wine.getWineName()}</td>
                        <td>${wine.getQuantity()}</td>
                        <td>${wine.getCost()}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <th colspan="4" style="text-align: center">Chiết khấu</th>
                    <th>${discount}%</th>
                </tr>
                <tr>
                    <th colspan="4" style="text-align: center">Tổng tiền</th>
                    <th>${total}</th>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>