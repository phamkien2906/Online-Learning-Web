<%-- 
    Document   : profile
    Created on : Jan 28, 2023, 12:42:39 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="shortcut icon" href="images/LogoShoes.png" type="">

        <title> OnlineLearning </title>

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

    </head>

    <body>
        <script type="text/javascript">
            function show() {
                var x = document.getElementById("profile");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
            }
        </script>
        <section class="book_section layout_padding">
            <div id="profile" style="display: block">
                <div class="container" >




                    <div class="row">
                        <div class="col-md-6">
                            <div class="form_container">
                                <form action="" style="line-height: 2.5">
                                    <div class="heading_container">
                                        <h2>
                                            UserID: ${sessionScope.account.getUser_id()}
                                            <br/>
                                            Username: ${sessionScope.account.getUser_name()}
                                        </h2>
                                    </div>
                                    <div>
                                        Email: ${sessionScope.account.getUser_mail()}
                                    </div>
                                    <div>
                                        Phone: ${sessionScope.account.getUser_phone()}
                                    </div>
                                    <div>
                                        Address: ${sessionScope.account.getUser_address()}
                                    </div>
                                    <div>
                                        Role: ${sessionScope.account.getUser_role()}
                                    </div>
                                    <div>
                                        Gender: <img src="${sessionScope.account.getUser_avatar()}" alt="alt" width="36px" hight="36px"/>
                                    </div>                                 
                                    <a href="home" style="border: orange solid; padding: 8px 30px;
                                       border-radius: 40px; color: white; background-color: orange">
                                        OK
                                    </a>
                                </form>
                            </div>
                        </div>


                        <div class="col-md-6">
                            <div class="form_container">
                                <form action="" style="line-height: 2.5">
                                    <div class="heading_container">
                                        <h2>
                                            My Course
                                        </h2>
                                    </div>
                                    <ul class="filters_menu" style="list-style: none">
                                        <c:forEach items="${requestScope.listenroll}" var="l" >

                                            <li>
                                                <c:if test="${sessionScope.account.getUser_id()==l.getUser_id()}">
                                                    <c:forEach items="${requestScope.list}" var="listC">
                                                        <c:if test="${listC.getCourse_id()==l.getCourse_id()}">


                                                            Image:<img src="${listC.getCourse_image()}" width="80px" height="80px" alt="alt"/>
                                                            Name:${listC.getCourse_name()}  
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if>
                                            </li>
                                            <br>
                                        </c:forEach>   
                                    </ul>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end book section -->
    </body>
</html>
