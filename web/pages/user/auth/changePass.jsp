<%-- 
    Document   : Register
    Created on : Oct 15, 2022, 6:53:30 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OL</title>
        <link rel="stylesheet" href="./css/login.css"/>

    </head>
    <body>

        <div class="login-wrap">
            <div class="login-html">
                <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Change Password</label>
                <div class="login-form">
                    <form action="change">
                        <h3 style="color: red">${requestScope.ms}</h3>
                        <div class="sign-up-htm">
                            
                            <div class="group">
                                <label for="pass" class="label">Old Password</label>
                                <input id="pass" name="oldpass" type="password" class="input" data-type="password">
                            </div>
                            <input type="hidden" name="name" value="${sessionScope.account.getUser_name()}">
                            <div class="group">
                                <label for="pass" class="label">New Password</label>
                                <input id="pass" name="newpass" type="password" class="input" data-type="password">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Confirm Password</label>
                                <input id="pass" name="rpass" type="password" class="input" data-type="password">
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="SAVE">
                            </div>
                            <div class="hr"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
