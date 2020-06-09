<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/8/2020
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Danh sách tất cả sản phẩm</h1>
    <br>
    <br>
    <div>
        <table border="1">
            <tr>
                <th>Mã Sản Phẩm</th>
                <th>Tên Sản Phẩm</th>
                <th>Giá Sản Phẩm</th>
                <th>Tồn Kho</th>
            </tr>
            <c:forEach items="${wines}" var="wine">
                <tr>
                    <td>${wine.getId()}</td>
                    <td>${wine.getName()}</td>
                    <td>${wine.getPrice()}</td>
                    <td>${wine.getStock()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
