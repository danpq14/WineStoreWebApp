<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/10/2020
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<h1 style="text-align: center">Tìm kiếm hóa đơn</h1>
<div style="text-align: center">
    <div style="display: inline-block">
        <form action="/revenueOverTime" method="post">
            <div class="form-group row">
                <label class="col-4 col-form-label">Nhập khoảng thời gian muốn tra cứu doanh thu (yyyy-MM-dd)</label>
                <div class="col-8">
                    <input name="beginDate" type="date" class="form-control">
                </div>
                <br>
                <div class="col-8">
                    <input name="endDate" type="date" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <div class="offset-4 col-8">
                    <button name="submit" type="submit" class="btn btn-primary">Tra Cứu</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
