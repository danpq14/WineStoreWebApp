<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/9/2020
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Xuất kho</h1>
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
<div style="text-align: center">
    <div style="display: inline-block">
        <form action="/inventory?action=export&id=${wine.getId()}" method="post">
            <div class="form-group row">
                <label class="col-4 col-form-label">Số lượng</label>
                <div class="col-8">
                    <input name="amount" type="text" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-4 col-form-label">Mã Khách Hàng</label>
                <div class="col-8">
                    <input name="customerId" type="text" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <div class="offset-4 col-8">
                    <button name="submit" type="submit" class="btn btn-primary">Thực hiện</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
