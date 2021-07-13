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
import lungnv.shopping.BookDAO;
import lungnv.shopping.BookDTO;
import lungnv.user.BookError;

/**
 *
 * @author NGUYEN VAN LUNG SE140193
 */
public class CreateBookController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "createBook.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String bookID = request.getParameter("bookID");
            String bookName = request.getParameter("bookName");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String statusID = request.getParameter("statusID");
            String categoryID = request.getParameter("categoryID");
            String image = request.getParameter("image");

            BookError bookError = new BookError();
            boolean check = true;
            if (bookID.length() > 10 || bookID.length() < 1) {

                bookError.setBookIDError("Book ID length must be [1,10]");
                check = false;
            }
            if (bookName.length() > 50 || bookName.length() < 1) {
                bookError.setBookNameError("Book Name length must be [1,50]");
                check = false;
            }
             if (description.length() > 50 || description.length() < 1) {
                bookError.setStatusIDError("Description length must be [1,50]]");
                check = false;
            }
            if (statusID.length() > 10 || statusID.length() < 1) {
                bookError.setStatusIDError("Status ID length must be [1,10]");
                check = false;
            }

            if (categoryID.length() > 10 || categoryID.length() < 1) {
                bookError.setCategoryIDError("Category ID length must be [1,10]");
                check = false;
            }
            if (image.length() < 1) {
                bookError.setStatusIDError("Image not null");
                check = false;
            }

            if (check) {
                BookDAO dao = new BookDAO();
                BookDTO book = new BookDTO(bookID, bookName, description, price, quantity, statusID, categoryID, image);
                boolean checkDuplicate = dao.checkDuplicate(bookID);
                if (checkDuplicate) {
                    bookError.setBookIDError("Duplicate bookID: " + bookID + " !");
                    request.setAttribute("BOOK_ERROR", bookError);
                } else {
                    boolean checkInsert = dao.insertBook(book);
                    if (checkInsert) {
                        url = SUCCESS;
                    } else {
                        request.setAttribute("BOOK_ERROR", bookError);
                    }
                }

            } else {
                request.setAttribute("BOOK_ERROR", bookError);
            }
        } catch (Exception e) {
            log("Error at create Book: " + e.toString());
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
