<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/9/2020
  Time: 9:01 AM
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
</head>
<body>
<h1 style="text-align: center">CHỈNH SỬA KHÁCH HÀNG</h1>
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
                <td>${custoemr.getDiscount()}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<div style="text-align: center">
    <div style="display: inline-block">
        <form action="/editCustomer?id=${customer.getId()}" method="post">
            <div class="form-group row">
                <label for="text1" class="col-4 col-form-label">Tên khách hàng</label>
                <div class="col-8">
                    <input id="text1" name="name" type="text" class="form-control" value="${customer.getName()}">
                </div>
            </div>
            <div class="form-group row">
                <label for="text2" class="col-4 col-form-label">Số điện thoại</label>
                <div class="col-8">
                    <input id="text2" name="phone" type="text" class="form-control" value="${customer.getPhone()}">
                </div>
            </div>
            <div class="form-group row">
                <label for="text3" class="col-4 col-form-label">Tỉ lệ chiết khấu</label>
                <div class="col-8">
                    <input id="text3" name="discount" type="text" class="form-control" value="${customer.getDiscount()}">
                </div>
            </div>
            <div class="form-group row">
                <div class="offset-4 col-8">
                    <button name="submit" type="submit" class="btn btn-primary">Lưu thay đổi</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
