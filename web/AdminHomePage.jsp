<%--
  Created by IntelliJ IDEA.
  User: Minh Khang
  Date: 6/11/2020
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
    <title>Test</title>
</head>
<body>
<header>
    <nav class="navbar-custom navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Trang chủ</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/customerAction?action=showAllProduct">Danh sách sản phẩm <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/topProduct">Top sản phẩm bán chạy</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/searchProduct">Tra cứu sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="views/managerPage/managerPage.jsp">Menu Quản Lý</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/#"><p>Xin Chào ${customer.getName()}</p></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logOut">Đăng Xuất</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="hero">
        <div class="fadeInDown animated">
            <h1 style="color: white">Welcome To My World<br>Sanjay Swami</h1>
        </div>
    </div>
</header>

<footer class="mainfooter" role="contentinfo" id="contact">
    <div class="footer-middle">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <!--Column1-->
                    <div class="footer-pad">
                        <h4>Dummy Text</h4>
                        <ul class="list-unstyled">
                            <li><a href="#"></a></li>
                            <li><a href="#">One</a></li>
                            <li><a href="#">Two</a></li>
                            <li><a href="#">Three</a></li>
                            <li><a href="#">Five</a></li>
                            <li><a href="#">Six</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <!--Column1-->
                    <div class="footer-pad">
                        <h4>Dummy Text</h4>
                        <ul class="list-unstyled">
                            <li><a href="#"></a></li>
                            <li><a href="#">One</a></li>
                            <li><a href="#">Two</a></li>
                            <li><a href="#">Three</a></li>
                            <li><a href="#">Five</a></li>
                            <li><a href="#">Six</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <!--Column1-->
                    <div class="footer-pad">
                        <h4>Dummy Text</h4>
                        <ul class="list-unstyled">
                            <li><a href="#"></a></li>
                            <li><a href="#">One</a></li>
                            <li><a href="#">Two</a></li>
                            <li><a href="#">Three</a></li>
                            <li><a href="#">Five</a></li>
                            <li><a href="#">Six</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <!--Column1-->
                    <div class="footer-pad">

                        <div class="social">
                            <a href="#" class="social-icon facebook"><span class="fa fa-facebook"></span></a>

                            <a href="#"  class="social-icon twitter"><span class="fa fa-twitter"></span></a>


                            <a href="#" class="social-icon google-plus"><span class="fa fa-google-plus"></span></a>

                            <a href="#" class="social-icon linkedin"><span class="fa fa-linkedin"></span></a>
                        </div>
                        <p class="text-xs-center">© Copyright 2017 - 2018 </p>
                    </div>

                </div>
            </div>
        </div>
    </div>

</footer>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>