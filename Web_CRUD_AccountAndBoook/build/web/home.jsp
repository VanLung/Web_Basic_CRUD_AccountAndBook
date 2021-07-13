<%-- 
    Document   : home
    Created on : Jul 6, 2021, 12:23:57 PM
    Author     : NGUYEN VAN LUNG SE140193
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>


    <body>
        <c:set var="user" value="${sessionScope.USER}" />
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home.jsp">BookShop</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">


                    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="show">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">0</span>
                        </a>
                    </form>

                    <ul class="navbar-nav col-auto">
                        <li class="nav-item">
                        </li>

                        <li class="nav-item">

                            <c:if test ="${not empty user}">


                                <c:url var="logoutLink" value="MainController">
                                    <c:param name="action" value="Logout"></c:param>
                                </c:url>
                                <a href="${logoutLink}">Logout</a>

                            </c:if>


                            <c:if test ="${empty user}">
                                <a class="nav-link" href="login.jsp">Login</a>
                            </c:if>

                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center" >
            <img src="assest\image\Background.png" width="100%" align="center">

            <div class="container">
                <h1 class="jumbotron-heading">Siêu thị sách chất lượng cao</h1>
                <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm sách trên toàn Thế Giới</p>

            </div>
        </section>
        <!--end of menu-->
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Category</a></li>
                            <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${listCa}" var="o">
                                <li class="list-group-item text-white ${tag ==o.categoryID ? "active":""}"> <a href="CategoryController?categoryID=${o.categoryID}">${o.categoryName}</a></li>

                            </c:forEach>
                        </ul>
                    </div>

                </div>

                <div class="col-sm-9" value="Home">
                    <div class="row">
                        <c:forEach items="${listB}" var="o">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card">
                                    <img class="card-img-top" src="${o.image}" alt="Card image cap">

                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="DetailController?bookID=${o.bookName}"  title="View Book"</a></h4>
                                        <p class="card-text show_txt">${o.description}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${o.price} VND</p>
                                            </div>
                                            <div class="col">
                                                <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>

        <!-- Footer -->

        <div class="container">
            <div class="row">
                <div class="col-auto mr-auto">
                    <h5>BookShop</h5>
                    <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                    <p class="mb-0">  © 2021. Sách Tốt Company.</p>
                    <li><i class="fa fa-home mr-2"></i> An Phu Tay, An Phu Tay-Hung Long Ward,Binh Chanh District, Ho Chi Minh City.</li>
                    <li><i class="fa fa-phone mr-2"></i> (038)724.34.97.</li>
                    <li><i class="fa fa-envelope mr-2"></i>cskh@sachtot.com.</li>
                    </li>
                    </p>

                </div>

                <div class="col-auto">
                    <h5>Contact</h5>
                    <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                    <ul class="list-unstyled">
                        <li><a href="https://metap.vn/749081">© 2021 NGUYỄN VĂN LƯNG</a></li>
                    </ul>
                </div>

            </div>
        </div>

    </body>
</html>


