<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1 style="text-align: center">Danh sách hóa đơn có doanh thu cao nhất </h1>
<div>
    <div style="text-align: center">
        <div class="result-table" style="display: inline-block">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Mã Hóa Đơn</th>
                    <th scope="col">Ngày Mua</th>
                    <th scope="col">Tổng tiền</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td><a href="/orderDetail?id=${order.getOrderId()}">${order.getOrderId()}</a></td>
                        <td>${order.getDate()}</td>
                        <td>${order.getTotalCost()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

