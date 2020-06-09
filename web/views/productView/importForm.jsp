<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/9/2020
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
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
<h1 style="text-align: center">Nhập kho</h1>
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
        <form action="/inventory?action=import&id=${wine.getId()}" method="post">
            <div class="form-group row">
                <label for="text" class="col-4 col-form-label">Số lượng</label>
                <div class="col-8">
                    <input id="text" name="amount" type="text" class="form-control">
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