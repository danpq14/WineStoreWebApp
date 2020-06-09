<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/9/2020
  Time: 4:52 PM
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
<h1 style="text-align: center">Thêm mới sản phẩm thành công</h1>
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
                        <td><a href="/editProduct?id=${wine.getId()}">Chỉnh sửa</a></td>
                        <td><a href="/inventory?action=import&id=${wine.getId()}">Nhập Kho</a></td>
                        <td><a href="/inventory?action=export&id=${wine.getId()}">Xuất Kho</a></td>
                        <td><a href="/deleteProduct?id=${wine.getId()}">Xóa</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
