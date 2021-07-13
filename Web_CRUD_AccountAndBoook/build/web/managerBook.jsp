<%-- 
    Document   : managerBook
    Created on : Jul 9, 2021, 10:47:49 PM
    Author     : NGUYEN VAN LUNG SE140193
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="lungnv.shopping.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="css/searchAccount.css" rel="stylesheet" type="text/css"/>
        <title>Manager Page</title>


    </head>
    <body>

        <c:if test="${sessionScope.USER.roleID == 'AD'}">
            <h1>MANAGER SYSTEM</h1>
            <h1>
                Welcome: ${sessionScope.LOGIN_USER.userName}
            </h1>
            <h2>This is Admin Page</h2>

            <div id="cover">
                <form action="MainController" method="GET">
                    <div class="tb">
                        <div class="td">
                            <input id="searchplaceholder" type="text" name="SearchBook" value=""  placeholder="Search Book Name..." required>
                        </div>
                        <div class="td" id="s-cover">
                            <button type="submit" name="action" value="SearchBook">
                                <div id="s-circle"></div>
                                <span></span>
                            </button>
                        </div>
                    </div>
                    </br>
                    <a href="createBook.jsp">Add New Book</a>
                    <div>
                        </br>
                        <a href="admin.jsp">Return to admin page</a> </br>
                    </div>
                    <div>
                        <c:url var="logoutLink" value="MainController">
                            <c:param name="action" value="Logout"></c:param>
                        </c:url>
                        </br>
                        <a  href="${logoutLink}">Logout</a>
                    </div>

                </form>
            </div>
            <div id= "tableAccount">
                <c:if  test="${requestScope.LIST_BOOK != null}">
                    <c:if test="${not empty requestScope.LIST_BOOK}">
                        <table border="1">
                            <thead >
                                </br> </br></br></br> </br></br>

                                <tr >
                                    <th>No</th>
                                    <th>Book ID</th>
                                    <th>Book Name</th>
                                    <th>Description</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Status ID</th>
                                    <th>Category ID</th>
                                    <th>Image</th>
                                    <th>Update</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dto" varStatus="counter" items="${requestScope.LIST_BOOK}">
                                <form action="MainController">
                                    </br>

                                    <tr>
                                        <td>${counter.count}</td>

                                        <td>${dto.bookID}</td>

                                        <td>
                                            <!--${dto.bookName}-->
                                            <input type="text" name="bookName" minlength="1" maxlength="50" value="${dto.bookName}"/>
                                        </td>

                                        <td>
                                            <!--${dto.description}-->
                                            <input type="text" name="description" minlength="1" maxlength="50" value="${dto.description}"/>
                                        </td>

                                        <td>
                                            <!--${dto.price}-->
                                            <input type="number" min="1" step="any" name="price" value="${dto.price}"/>
                                        </td>

                                        <td>
                                            <!--${dto.quantity}-->
                                            <input type="number" min="1" step="any" name="quantity" value="${dto.quantity}"/>
                                        </td>

                                        <td>
                                            <!--${dto.statusID}-->
                                            <input type="text" pattern="(\S0)\d{1}" name="statusID"   minlength="1" maxlength="10"  value="${dto.statusID}"/>
                                        </td>

                                        <td>
                                            <!-- ${dto.categoryID}-->
                                            <input type="text" pattern="(\C0)\d{1}"  name="categoryID" value="${dto.categoryID}"/>
                                        </td>

                                        <td>
                                            <!-- ${dto.image}-->
                                            <input type="url" name="image" value="${dto.image}"/>
                                        </td>

                                        <td>
                                            <input  type="submit" name="action" value="UpdateBook"/>
                                            <input type="hidden" name="bookID" value="${dto.bookID}"/>
                                            <input type="hidden" name="SearchBook" value="${sessionScope.SearchBook}"/>


                                        </td>

                                        <td>
                                            <input type="submit" name="action" value="DeleteBook" />
                                            <input type="hidden" name="bookID" value="${dto.bookID}"/>
                                            <input type="hidden" name="SearchBook" value="${sessionScope.SearchBook}"/>
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <c:if test="${empty requestScope.LIST_BOOK}">
                        NO RECORD FOUND!
                    </c:if>
                </c:if>
            </div>
        </c:if>

        <c:if test="${empty  USER  or sessionScope.USER.roleID == 'US'}">
            <h2>Warning: You need to have role admin</h2>
            <a href="home.jsp"> Return to home page</a>
        </c:if>
    </body>
</html>

