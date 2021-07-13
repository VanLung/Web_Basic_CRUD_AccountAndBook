/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lungnv.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lungnv.user.UserDAO;
import lungnv.user.UserDTO;
import lungnv.user.UserError;

/**
 *
 * @author NGUYEN VAN LUNG SE140193
 */
public class CreateUserController extends HttpServlet {

    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String confirm_password = request.getParameter("confirm_password");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String roleID = "US";
            String statusID = request.getParameter("statusID");

            boolean check = true;
            UserError userError = new UserError();
            if (userID.length() > 10 || userID.length() < 1) {

                userError.setUserIDError("UserID length must be [1,10]");
                check = false;
            }
            if (userName.length() > 50 || userName.length() < 1) {
                userError.setUserNameError("User Name length must be [1,50]");
                check = false;
            }
            if (password.length() > 10 || password.length() < 1) {
                userError.setPasswordError("Password length must be [1,10]");
                check = false;
            }
            if (!password.equals(confirm_password)) {
                userError.setConfirmPwError("Confirm password is wrong");
                check = false;
            }
            if (phone.length() > 15 || phone.length() < 1) {
                userError.setPhoneError("Phone length must be 10 number");
                check = false;
            }
            if (address.length() > 50 || address.length() < 2) {
                userError.setAddressError("Address length must be [2,50]");
                check = false;
            }

            if (statusID.length() > 10 || statusID.length() < 1) {
                userError.setStatusIDError("Status ID length must be [1,10]");
                check = false;
            }

            if (check) {
                UserDAO dao = new UserDAO();
                UserDTO user = new UserDTO(userID, userName, password, phone, address, email, roleID, statusID);
                boolean checkDuplicate = dao.checkDuplicate(userID);
                if (checkDuplicate) {
                    userError.setUserIDError("Duplicate UserID: " + userID + " !");
                    request.setAttribute("USER_ERROR", userError);
                } else {
                    boolean checkInsert = dao.insert(user);
                    if (checkInsert) {
                        url = SUCCESS;
                    } else {
                        userError.setMessageError("Can not insert, unkown error");
                        request.setAttribute("USER_ERROR", userError);
                    }
                }

            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at create User: " + e.toString());
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
