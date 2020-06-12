<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/10/2020
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
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
<h1 style="text-align: center">THÔNG TIN KHÁCH HÀNG</h1>
<div style="text-align: center">
    <div style="display: inline-block">
        <h4>Mã hóa đơn : ${order.getOrderId()}</h4>
        <h4>Mã khách hàng : ${order.getCustomerId()}</h4>
        <h4>Tên khách hàng : ${customer.getName()}</h4>
        <h4>Ngày mua : ${order.getDate()}</h4>
    </div>
</div>
<div style="text-align: center">
    <div class="result-table" style="display: inline-block">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Tên sản phẩm</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Thành Tiền</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${wines}" var="wine">
                <tr>
                    <td>${wine.getWineName()}</td>
                    <td>${wine.getQuantity()}</td>
                    <td>${wine.getCost()}</td>
                </tr>
            </c:forEach>
            <tr>
                <th colspan="2">Tổng tiền</th>
                <th>${order.getTotalCost()}</th>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>