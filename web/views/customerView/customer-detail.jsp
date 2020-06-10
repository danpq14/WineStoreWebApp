<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/10/2020
  Time: 8:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>thông tin khách hàng</title>
    <link rel="stylesheet"href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<body>
<h1 style="text-align: center">THÔNG TIN KHÁCH HÀNG</h1>
<div style="text-align: center">
    <div style="display: inline-block">
        <h4>Tổng số hóa đơn đã mua : ${numberOfOrder}</h4>
        <h4>Hóa đơn có doanh thu cao nhất : ${maxRevenue}</h4>
        <h4>Tổng doanh thu : ${totalRevenue}</h4>
        <h4><a href="/orderList?id=${customer.getId()}">Danh sách tất cả các hóa đơn</a></h4>
    </div>
</div>
<div style="text-align: center">
    <div class="result-table" style="display: inline-block">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Mã Khách hàng</th>
                <th scope="col">Tên khách hàng</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Tỉ lệ chiết khấu</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">${customer.getId()}</th>
                <td>${customer.getName()}</td>
                <td>${customer.getPhone()}</td>
                <td>${customer.getDiscount()}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
