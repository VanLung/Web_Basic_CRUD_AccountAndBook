/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lungnv.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NGUYEN VAN LUNG SE140193
 */
public class MainController extends HttpServlet {
//login-logout

    private static final String ERROR = "error.jsp";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String HOME_CONTROLLER = "HomeController";

//CRUD Account
    private static final String SEARCH_ACCOUNT_CONTROLLER = "SearchAccountController";
    private static final String DELETE_ACCOUNT_CONTROLLER = "DeleteAccountController";
    private static final String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountController";
    private static final String CREATE_USER_CONTROLLER = "CreateUserController";
//CRUD Book
    private static final String SEARCH_BOOK_CONTROLLER = "SearchBookController";
    private static final String DELETE_BOOK_CONTROLLER = "DeleteBookController";
    private static final String UPDATE_BOOK_CONTROLLER = "UpdateBookController";
    private static final String CREATE_BOOK_CONTROLLER = "CreateBookController";

//Shopping Cart
    private static final String VIEW_CART_PAGE = "viewCart.jsp";
    private static final String ADD_TO_CART_CONTROLLER = "AddToCartController";
    private static final String MODIFY_CART_CONTROLLER = "ModifyCartController";
    private static final String REMOVE_CART_CONTROLLER = "RemoveCartController";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            //Login-Logout
            if ("Login".equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if ("Logout".equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if ("Home".equals(action)) {
                url = HOME_CONTROLLER;
            }//CRUD ACCOUNT
            else if ("Search Account".equals(action)) {
                url = SEARCH_ACCOUNT_CONTROLLER;
            } else if ("DeleteAccount".equals(action)) {
                url = DELETE_ACCOUNT_CONTROLLER;
            } else if ("UpdateAccount".equals(action)) {
                url = UPDATE_ACCOUNT_CONTROLLER;
            } else if ("CreateUser".equals(action)) {
                url = CREATE_USER_CONTROLLER;
            } //CRUD BOOK
            else if ("SearchBook".equals(action) || "SearchCa".equals(action)) {
                url = SEARCH_BOOK_CONTROLLER;
            } else if ("DeleteBook".equals(action)) {
                url = DELETE_BOOK_CONTROLLER;
            } else if ("UpdateBook".equals(action)) {
                url = UPDATE_BOOK_CONTROLLER;
            } else if ("CreateBook".equals(action)) {
                url = CREATE_BOOK_CONTROLLER;
            } //Shopping Cart
            else if ("Select".equals(action)) {
                url = ADD_TO_CART_CONTROLLER;
            } else if ("view Cart".equals(action)) {
                url = VIEW_CART_PAGE;
            } else if ("Modify".equals(action)) {
                url = MODIFY_CART_CONTROLLER;
            } else if ("Remove".equals(action)) {
                url = REMOVE_CART_CONTROLLER;
            } else {
                session.setAttribute("ERROR_MESSAGE", "Function is not support!");
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
