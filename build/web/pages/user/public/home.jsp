<%-- 
    Document   : home
    Created on : Oct 1, 2022, 9:47:14 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

    <head>
        <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <!--        <link rel="shortcut icon" href="images/OL.jpg" type="">-->

        <title> Online Learning</title>

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <!-- font awesome style -->
        <link href="css/font-awesome.min.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            h6{
                color:white;
                font-size: 12px;
            }
            .old{
                text-decoration: line-through;
                color:red;
            }
            input[type=submit]{
                width:100px;
                height:30px;
                background-color: #005cbf;
                border-radius: 10px;
            }
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 13px;
                min-width: 30px;
                min-height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 2px !important;
                text-align: center;
                padding: 0 6px;
            }
            .pagination li a:hover {
                color: #666;
            }
            .pagination li.active a, .pagination li.active a.page-link {
                background: #03A9F4;
            }
            .pagination li.active a:hover {
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }



        </style>
        <script>
            $(document).ready(function () {
                // Activate tooltip
                $('[data-toggle="tooltip"]').tooltip();

                // Select/Deselect checkboxes
                var checkbox = $('table tbody input[type="checkbox"]');
                $("#selectAll").click(function () {
                    if (this.checked) {
                        checkbox.each(function () {
                            this.checked = true;
                        });
                    } else {
                        checkbox.each(function () {
                            this.checked = false;
                        });
                    }
                });
                checkbox.click(function () {
                    if (!this.checked) {
                        $("#selectAll").prop("checked", false);
                    }
                });
            });
        </script>       
    </head>

    <body>
        <div class="hero_area">
            <div class="bg-box">
                <img src="images/OL.jpg" alt="">
            </div>
            <!-- header section strats -->
            <header class="header_section">
                <div class="container">
                    <nav class="navbar navbar-expand-lg custom_nav-container ">
                        <a class="navbar-brand" href="category">
                            <span>
                                OnlineLearning
                            </span>
                        </a>

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class=""> </span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav  mx-auto ">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#">HOME <span class="sr-only">(current)</span></a>
                                </li>
                                <c:if test="${sessionScope.account==null}">
                                    <li class="nav-item active">
                                        <a class="nav-link" href="alogin">Login <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="nav-item active">
                                        <a class="nav-link" href="signup">Register</a>    
                                    </li>
                                </c:if>


                                <c:if test="${(sessionScope.account!=null)&&(sessionScope.account.getUser_role()==0)}">

                                    <li class="nav-item active">
                                        <a class="nav-link" href="profile" onclick="show()">Profile <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="change">Change Password</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="logout">Logout</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="discussion">Discussion</a>
                                    </li>

                                </c:if>
                                <c:if test="${(sessionScope.account!=null)&&(sessionScope.account.getUser_role()==1)}">

                                    <li class="nav-item active">
                                        <a class="nav-link" href="profile" onclick="show()">Profile <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="change">Change Password</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="logout">Logout</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="discussion">Discussion</a>
                                    </li>

                                </c:if>

                            </ul>
                            <div class="user_option" >
                                <a href="profile.jsp" class="user_link">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </a>
                                <a class="cart_link" href="show">
                                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029" style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                                    <g>
                                    <g>
                                    <path d="M345.6,338.862c-29.184,0-53.248,23.552-53.248,53.248c0,29.184,23.552,53.248,53.248,53.248
                                          c29.184,0,53.248-23.552,53.248-53.248C398.336,362.926,374.784,338.862,345.6,338.862z" />
                                    </g>
                                    </g>
                                    <g>
                                    <g>
                                    <path d="M439.296,84.91c-1.024,0-2.56-0.512-4.096-0.512H112.64l-5.12-34.304C104.448,27.566,84.992,10.67,61.952,10.67H20.48
                                          C9.216,10.67,0,19.886,0,31.15c0,11.264,9.216,20.48,20.48,20.48h41.472c2.56,0,4.608,2.048,5.12,4.608l31.744,216.064
                                          c4.096,27.136,27.648,47.616,55.296,47.616h212.992c26.624,0,49.664-18.944,55.296-45.056l33.28-166.4
                                          C457.728,97.71,450.56,86.958,439.296,84.91z" />
                                    </g>
                                    </g>
                                    <g>
                                    <g>
                                    <path d="M215.04,389.55c-1.024-28.16-24.576-50.688-52.736-50.688c-29.696,1.536-52.224,26.112-51.2,55.296
                                          c1.024,28.16,24.064,50.688,52.224,50.688h1.024C193.536,443.31,216.576,418.734,215.04,389.55z" />
                                    </g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    </svg>
                                </a>
                                <!--                                <form class="form-inline" action="search" >
                                                                    <input type="text" name="search" placeholder="Search...">-->
                                <!--                                    <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit">
                                                                        <i class="fa fa-search" aria-hidden="true"></i>
                                                                
                                
                                                                    </button>-->
                                <!--                                </form>-->

                                <a href="#searchpr  oduct" data-toggle="modal">
                                    <button class="btn  my-2 my-sm-0 nav_search-btn">
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </button>
                                </a>
                                <a href="show" class="order_online">
                                    Order Online
                                </a>
                            </div>

                        </div>
                    </nav>
                </div>
            </header>

            <!-- end header section -->
            <!-- slider section -->
            <section class="slider_section ">
                <div id="customCarousel1" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                OnlineLearning-Hoc truc tuyen thoa suc sang tao!
                                            </h1>
                                            <p>
                                                OnlineLearning<br/>
                                                Welcome<br/>
                                                Goodbye.<br/>
                                            </p>
                                            <div class="btn-box">
                                                <a href="" class="btn1">
                                                    Order Now
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item ">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                Online Learning CONFIDENT IN STEP!
                                            </h1>
                                            <p>
                                                Welcome to  Online Learning.<br/>
                                                Thank you for using our service.<br/>
                                                Wish you have a great experience at Online Learning.<br/>
                                            </p>
                                            <div class="btn-box">
                                                <a href="" class="btn1">
                                                    Order Now
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                STUDYYYYYYYYYYYYYYYYYYYYYYYY
                                            </h1>
                                            <p>
                                                CODE LEARNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN
                                            </p>
                                            <div class="btn-box">
                                                <a href="" class="btn1">
                                                    Order Now
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <ol class="carousel-indicators">
                            <li data-target="#customCarousel1" data-slide-to="0" class="active"></li>
                            <li data-target="#customCarousel1" data-slide-to="1"></li>
                            <li data-target="#customCarousel1" data-slide-to="2"></li>
                        </ol>
                    </div>
                </div>

            </section>
            <!-- end slider section -->
        </div>



        <!-- end offer section -->

        <!-- food section -->

        <section class="food_section layout_padding-bottom">
            <div class="container">
                <div class="heading_container heading_center">
                    <h2 style="font-size: 60px">
                        Our Course
                    </h2>
                </div>

                <!--                <ul class="filters_menu" style="background-color: orange; font-weight: 600;
                                    font-style: italic; font-family: 'Dancing Script', cursive;
                                    height: 60px; font-size: 30px">
                                    <li ><a href="product?cid=${0}">|All|</a></li>
                <c:forEach items="${requestScope.listC}" var="listcourse">
                <li class="${tag==c.getCategoryID()?"active":""}">
                    <a href="product?cid=${c.getCategoryID()}">|${listcourses.getCourse_name()}|</a>
                </li>
                </c:forEach>
            </ul>-->


                <input type="hidden" name="num" value="1">
                <div class="filters-content">                        
                    <div class="row grid">                            
                        <c:forEach items="${requestScope.listC}" var="listC">
                            <div class="col-sm-6 col-lg-4">
                                <div class="box">
                                    <div>
                                        <div class="img-box">
                                            <a href="course?id=${listC.getCourse_id()}">
                                                <img src="${listC.getCourse_image()}" >
                                            </a>
                                        </div>
                                        <div class="detail-box">                                           
                                            <p>
                                                <a href="course?id=${listC.getCourse_id()}">
                                                    <h1>${listC.getCourse_name()}</h1>
                                                </a>
                                            </p>

                                            <!--                                            <h6>
                                                                                            Giá gốc:<span class="old">${listC.getCourse_price()*2} VNÐ</span>
                                                                                        </h6>-->
                                            <!--                                            <h6> So Luong: <input style="text-align: center" type="number" name="num" value="1" /></h6>-->
                                            <div class="options">

                                                <c:if test="${listC.getCourse_id()== l.course_id }">

                                                    <h5>Continue learning</h5>
                                                </c:if>
                                                <c:if test="${listC.getCourse_id()!= l.course_id }">
                                                    <h5>Sale: ${listC.getCourse_price()} VND</h5>
                                                </c:if>

                                                <a href="buy?id=${p.getProductId()}&num=1">
                                                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029" style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                                                    <g>
                                                    <g>
                                                    <path d="M345.6,338.862c-29.184,0-53.248,23.552-53.248,53.248c0,29.184,23.552,53.248,53.248,53.248
                                                          c29.184,0,53.248-23.552,53.248-53.248C398.336,362.926,374.784,338.862,345.6,338.862z" />
                                                    </g>
                                                    </g>
                                                    <g>
                                                    <g>
                                                    <path d="M439.296,84.91c-1.024,0-2.56-0.512-4.096-0.512H112.64l-5.12-34.304C104.448,27.566,84.992,10.67,61.952,10.67H20.48
                                                          C9.216,10.67,0,19.886,0,31.15c0,11.264,9.216,20.48,20.48,20.48h41.472c2.56,0,4.608,2.048,5.12,4.608l31.744,216.064
                                                          c4.096,27.136,27.648,47.616,55.296,47.616h212.992c26.624,0,49.664-18.944,55.296-45.056l33.28-166.4
                                                          C457.728,97.71,450.56,86.958,439.296,84.91z" />
                                                    </g>
                                                    </g>
                                                    <g>
                                                    <g>
                                                    <path d="M215.04,389.55c-1.024-28.16-24.576-50.688-52.736-50.688c-29.696,1.536-52.224,26.112-51.2,55.296
                                                          c1.024,28.16,24.064,50.688,52.224,50.688h1.024C193.536,443.31,216.576,418.734,215.04,389.55z" />
                                                    </g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    </svg>
                                                </a>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </section>               

        <!--end food section--> 
        <c:forEach items="${requestScope.listenroll}" var="l" >
            <c:out value="${l.getUser_id()}"></c:out>
        </c:forEach>






        <script src="js/jquery-3.4.1.min.js"></script>
        <!-- popper js -->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
        </script>
        <!-- bootstrap js -->
        <script src="js/bootstrap.js"></script>
        <!-- owl slider -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
        </script>
        <!-- isotope js -->
        <script src="https://unpkg.com/isotope-layout@3.0.4/dist/isotope.pkgd.min.js"></script>
        <!-- nice select -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
        <!-- custom js -->
        <script src="js/custom.js"></script>
        <!-- Google Map -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
        </script>
        <!-- End Google Map -->

    </body>

</html>

