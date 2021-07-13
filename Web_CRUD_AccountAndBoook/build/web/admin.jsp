<%-- 
    Document   : admin.jsp
    Created on : Jul 6, 2021, 12:22:08 PM
    Author     : NGUYEN VAN LUNG SE140193
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="lungnv.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>





<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="css/searchAccount.css" rel="stylesheet" type="text/css"/>

        <title>Admin Page</title>
    </head>
    <body>

        <c:if test="${sessionScope.USER.roleID == 'AD'}">


            <h1>
                Welcome: ${sessionScope.LOGIN_USER.userName}
            </h1>
            <h2>This is Admin Page</h2>

            <div id="cover">
                <form action="MainController" method="get">
                    <div class="tb">
                        <div class="td">
                            <input id="searchplaceholder" type="text" name="Search"  placeholder="Search Account..." required>
                        </div>
                        <div class="td" id="s-cover">
                            <button type="submit" name="action" value="Search Account">
                                <div id="s-circle"></div>
                                <span></span>
                            </button>
                        </div>
                    </div>

                    <div>
                        <c:url var="logoutLink" value="MainController">
                            <c:param name="action" value="Logout"></c:param>
                        </c:url>
                        </br>
                        <a  href="${logoutLink}">Logout</a>
                    </div>
                    <div>

                        </br>
                        <a  href="managerBook.jsp">CRUD Book</a>
                    </div>

                </form>
            </div>


            <div id= "tableAccount">
                <c:if  test="${requestScope.LIST_USER != null}">
                    <c:if test="${not empty requestScope.LIST_USER}">
                        <table border="1">
                            <thead >
                            </br> <br>

                            <tr >
                                </br>
                                <th>No</th>
                                <th>User ID</th>
                                <th>User Name</th>
                                <th>Password</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Email</th>
                                <th>Role ID</th>
                                <th>Status ID</th>
                                <th>Update</th>
                                <th>Delete</th>

                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dto" varStatus="counter" items="${requestScope.LIST_USER}">
                                <form action="MainController">
                                    </br>

                                    <tr>
                                        <td>${counter.count}</td>

                                        <td>${dto.userID}</td>

                                        <td>
                                            <!--${dto.userName}-->
                                            <input type="text" name="userName" minlength="1" maxlength="50" value="${dto.userName}"/>
                                        </td>

                                        <td>${dto.password}</td>

                                        <td>
                                            <!--${dto.phone}-->
                                            <input type="text" pattern="(\+84|0)\d{9,10}" name="phone" minlength="10" maxlength="10" value="${dto.phone}"/>
                                        </td>

                                        <td>
                                            <!--${dto.address}-->
                                            <input type="text" name="address" minlength="1" maxlength="50" value="${dto.address}"/>
                                        </td>

                                        <td>
                                            <!--${dto.email}-->
                                            <input type="email" name="email" value="${dto.email}"/>
                                        </td>

                                        <td>
                                            <!-- ${dto.roleID}-->
                                            <input type="text" pattern="US|AD" name="roleID" minlength="1" maxlength="10" value="${dto.roleID}"/>
                                        </td>

                                        <td>
                                            <!-- ${dto.statusID}-->
                                            <input type="text" pattern="(\S0)\d{1}" name="statusID"  minlength="1" maxlength="10" value="${dto.statusID}"/>
                                        </td>

                                        <td>
                                            <input  type="submit" name="action" value="UpdateAccount"/>
                                            <input type="hidden" name="userID" value="${dto.userID}"/>
                                            <input type="hidden" name="Search" value="${param.Search}"/>
                                        </td>

                                        <td>
                                            <input type="submit" name="action" value="DeleteAccount" />
                                            <input type="hidden" name="userID" value="${dto.userID}"/>
                                            <input type="hidden" name="Search" value="${param.Search}"/>
                                        </td>

                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>

                    </c:if>

                    <c:if test="${empty requestScope.LIST_USER}">
                        NO RECORD FOUND!
                    </c:if>

                </c:if>
            </div>

        </c:if> 


        <c:if test="${sessionScope.USER.roleID == 'US'}">
            <p>Your role is not accept</p>
            <a href="home.jsp"> Return to home page</a>
        </c:if> 



    </body>
</html>
