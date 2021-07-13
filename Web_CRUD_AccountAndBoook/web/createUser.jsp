<%-- 
    Document   : createUser
    Created on : Jul 7, 2021, 1:12:35 AM
    Author     : NGUYEN VAN LUNG SE140193
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="lungnv.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@page import="lungnv.user.UserError"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>


        <title>Sign Up Form</title>

    </head>
    <body>

       
        <div id="logregup-forms">
            <form class="form-signin" action="MainController" method="POST">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign up</h1>

                <input name="userID" type="text" minlength="1" maxlength="10" id="user-ID" class="form-control" placeholder="User ID"  minlength="1" maxlength="10" required="" autofocus="">
                ${requestScope.USER_ERROR.getUserIDError()} </br>

                <input name="userName" required="" type="text" id="user-name" class="form-control" placeholder="Full Name" minlength="1" maxlength="50" required="" autofocus="">
                ${requestScope.USER_ERROR.getUserNameError()} 


                <input name="password" type="password" id="password" onkeyup='check();' class="form-control" placeholder="Password" minlength="1" required autofocus="">

                <input name="confirm_password" type="password" id="confirm_password" onkeyup='check();' class="form-control" placeholder="Confirm Password" required autofocus="">
                ${requestScope.USER_ERROR.getConfirmPwError()} 
                <span id='message'></span>

                <input name="phone" type="text" pattern="(\+84|0)\d{9,10}" id="phone" class="form-control" placeholder="Phone Number" required="" autofocus="">
                ${requestScope.USER_ERROR.getPhoneError()} </br>

                <input name="address" type="text" minlength="1" maxlength="50" id="address" class="form-control" placeholder="Address" required="" autofocus="">
                ${requestScope.USER_ERROR.getAddressError()} </br>

                <input name="email" type="email"  id="email"    class="form-control" placeholder="Email" required="" autofocus="">
                ${requestScope.USER_ERROR.getEmailError()} </br>

                <input name="roleID" type="text" id="roleID" class="form-control" value="US" required="" autofocus="" readonly="true">
                ${requestScope.USER_ERROR.getRoleIDError()} </br>

                <input name="statusID" type="text" pattern="(\S0)\d{1}"  id="statusID" class="form-control" placeholder="Status ID" required="" autofocus="">
                ${requestScope.USER_ERROR.getStatusIDError()} </br>
                
                <input type="reset" value="Reset"/></br>
                <input lass="btn btn-primary btn-block" type="submit" name="action" value="CreateUser"/>

                ${requestScope.USER_ERROR.getMessageError()} 


            </form>

            <c:url var="logoutLink" value="MainController">
                <c:param name="action" value="Logout"></c:param>
            </c:url>
            <a href="login.jsp">Return to login page</a></br>
        </div>

    </body>
</html>
