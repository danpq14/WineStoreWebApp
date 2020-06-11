<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/11/2020
  Time: 8:20 AM
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
<h1 style="text-align: center">Danh sách khách hàng có doanh thu cao nhất </h1>
<div>
    <div style="text-align: center">
        <div class="result-table" style="display: inline-block">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Mã Khách Hàng</th>
                    <th scope="col">Tên Khách hàng</th>
                    <th scope="col">Tổng doanh thu</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${customers}" var="customer" varStatus="loop">
                    <tr>
                        <td><a href="/customerDetail?id=${customer.getId()}">${customer.getId()}</a></td>
                        <td>${customer.getName()}</td>
                        <td>${topRevenue.get(loop.index)}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>