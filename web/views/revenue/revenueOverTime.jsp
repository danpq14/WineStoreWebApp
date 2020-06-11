<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/10/2020
  Time: 4:04 PM
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
<h1 style="text-align: center">Tra Cứu Doanh Thu</h1>
<div>
    <div style="text-align: center">
        <div class="result-table" style="display: inline-block">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Khoảng Thời Gian</th>
                    <th scope="col">Tổng số hóa đơn</th>
                    <th scope="col">Tổng doanh thu</th>
                </tr>
                </thead>
                <tbody>
                    <tr style="text-align: center">
                        <td>${beginDate} đến ${endDate}</td>
                        <td>${amountOrder}</td>
                        <td>${revenue}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

</html>
