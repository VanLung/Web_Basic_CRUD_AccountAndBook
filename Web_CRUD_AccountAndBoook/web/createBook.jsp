<%-- 
    Document   : createBook
    Created on : Jul 10, 2021, 2:45:19 AM
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


        <title>Create Book Form</title>

    </head>
    <body>

        <div id="logregup-forms">
            <form class="form-signin" action="MainController" method="POST">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Create Book</h1>

                <input name="bookID" type="text" id="user-ID" class="form-control" placeholder="Book ID"  minlength="1" maxlength="10" required="" autofocus="">
                ${requestScope.BOOK_ERROR.getBookIDError()} </br>

                <input name="bookName" required="" type="text" id="user-name" class="form-control" placeholder="Book Name"  minlength="1" maxlength="50" required="" autofocus="">
                ${requestScope.BOOK_ERROR.getBookNameError()} </br>

                <input name="description" type="text"  minlength="1" maxlength="50" id="description" class="form-control" placeholder="Description" required="" autofocus="">
                ${requestScope.BOOK_ERROR.getDescriptionError()} </br>

                <input name="price" ype="number" min="1" step="any" id="price" class="form-control" placeholder="Price" required="" autofocus="">
                ${requestScope.BOOK_ERROR.getPriceError()} </br>

                <input name="quantity" type="number" min="1" step="any" id="quantity" class="form-control" placeholder="Quantity"  required="" autofocus="" >
                ${requestScope.BOOK_ERROR.getQuantityError()} </br>

                <input name="statusID" type="text" pattern="(\S0)\d{1}" id="statusID" class="form-control" placeholder="Status ID" required="" autofocus="">
                ${requestScope.BOOK_ERROR.getStatusIDError()} </br>

                <input name="categoryID" type="text"  pattern="(\C0)\d{1}" id="categoryID" class="form-control" placeholder="Category ID" required="" autofocus="">
                ${requestScope.BOOK_ERROR.getCategoryIDError()} </br>

                <input name="image" type="url" id="image" class="form-control" placeholder="Image" required="" autofocus="">
                ${requestScope.BOOK_ERROR.getImageError()} </br>

                <input type="reset" value="Reset"/></br>
                <input lass="btn btn-primary btn-block" type="submit" name="action" value="CreateBook"/>

                ${requestScope.BOOK_ERROR.getMessageError()} 


            </form>

            <c:url var="logoutLink" value="MainController">
                <c:param name="action" value="Logout"></c:param>
            </c:url>
            <a href="${logoutLink}">Logout</a>
            <a href="managerBook.jsp">Return to manager system page</a></br>
        </div>

    </body>
</html>

