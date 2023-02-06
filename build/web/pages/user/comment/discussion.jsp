<%-- 
    Document   : discussion
    Created on : Jan 26, 2023, 5:05:19 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Learning</title>
        <link rel="stylesheet" href="discussion.css"/>
    </head>
    <body>
        <h2>Discusion</h2>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <div class="container bootdey">
            <div class="col-md-12 bootstrap snippets">
                <c:if test="${sessionScope.account !=null}"> 
                    <div class="panel">
                        <div class="panel-body">
                            <form action="discussion" method="post" enctype="multipart/form-data">
                                <textarea class="form-control" rows="2" placeholder="What are you thinking?" name="discussion"></textarea>
                                <input class="form-control" rows="2" type="file" name="upFile" >
                                <div class="mar-top clearfix">
                                    <button style="color: blue" class="btn btn-sm btn-primary " type="submit"><i class="fa fa-pencil fa-fw"></i> Post</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </c:if>
                <c:forEach items="${requestScope.discussion}" var="i" >
                    <div class="panel">
                        <div class="panel-body">
                            <!-- Newsfeed Content -->
                            <!--===================================================-->
                            <div class="media-block">
                                <a class="media-left" href="#"><img src="src""/></a>
                                <div class="media-body">
                                    <div class="mar-btm">
                                        <a href="#" class="btn-link text-semibold media-heading box-inline">${i.user.getUser_name()}</a>
                                        <p class="text-muted text-sm"> ${i.timediff}</p>
                                    </div>
                                    <p>${i.discussion_detail}</p>
                                    <c:if test="${i.discussion_image != null && !i.discussion_image.equals(SS)}" >
                                        <img style="width:500px;height:400px" src="upload/${i.discussion_image}" />
                                    </c:if>
                                    <div class="pad-ver">
                                        <div class="btn-group">
                                            <a class="btn btn-sm btn-default btn-hover-success" href="discussion?like=${i.discussion_id}"><i class="fa fa-thumbs-up">${i.discussion_like}</i></a>
                                            <!--<a class="btn btn-sm btn-default btn-hover-danger" href="#"><i class="fa fa-thumbs-down"></i></a>-->
                                        </div>
                                        <c:if test="${sessionScope.account !=null}">
                                            <form action="discussion" method="post" enctype="multipart/form-data">
                                                <input type="text" placeholder="Reply comment" name="discusionReply">
                                                <input type="hidden" name="Replyof" value="${i.discussion_id}">
                                                <!--<input type="file" name="upFile" >-->
                                                <input style="color: blue" type="submit" value="Send">
                                            </form>
                                        </c:if>
                                    </div>
                                    <hr>
                                    <!-- Comments -->
                                    <c:forEach items="${requestScope.replydiscussion}" var="j">
                                        <c:if test="${j.discussion_reply== i.discussion_id}">
                                            <div>
                                                <div class="media-block">
                                                    <a class="media-left" href="#"><img src="src"/></a>
                                                    <div class="media-body">
                                                        <div class="mar-btm">
                                                            <a href="#" class="btn-link text-semibold media-heading box-inline">${j.user.getUser_name()}</a>
                                                            <p class="text-muted text-sm"> ${j.timediff}</p>
                                                        </div>
                                                        <p>${j.discussion_detail}</p>
                                                        <div class="pad-ver">
                                                            <div class="btn-group">
                                                                <a class="btn btn-sm btn-default btn-hover-success active" href="discussion?like=${j.discussion_id}"><i class="fa fa-thumbs-up">${j.discussion_like}</i> </a>
                                                            </div>  
                                                            <c:if test="${sessionScope.account !=null}">
                                                                <form action="discussion" method="post" enctype="multipart/form-data">
                                                                    <input type="text" placeholder="Reply comment" name="discusionReply">
                                                                    <input type="hidden" name="Replyof" value="${i.discussion_id}">
                                                                    <!--<input  type="file" name="upFile" >-->
                                                                    <input style="color: blue" type="submit" value="Send">
                                                                </form>
                                                            </c:if>
                                                        </div>

                                                        <hr>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>

                                </div>
                            </div>
                            <!--===================================================-->
                            <!-- End Newsfeed Content -->
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
