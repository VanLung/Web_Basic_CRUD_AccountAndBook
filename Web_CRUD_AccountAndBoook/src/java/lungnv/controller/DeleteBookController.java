/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lungnv.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lungnv.shopping.BookDAO;
import lungnv.shopping.BookDTO;
import lungnv.user.CategoryDAO;
import lungnv.user.UserDAO;
import lungnv.user.UserDTO;

/**
 *
 * @author NGUYEN VAN LUNG SE140193
 */
public class DeleteBookController extends HttpServlet {

    private static final String ERROR = "SearchBookController";
    private static final String SUCCESS = "managerBook.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        try {
            String bookID = request.getParameter("bookID");
            BookDAO dao = new BookDAO();
            BookDTO book = new BookDTO(bookID, bookID, "", 0, 0, bookID, bookID, url);
            HttpSession session = request.getSession();
            boolean check = dao.deleteBook(bookID);
            if (check) {
                String searchValue = request.getParameter("SearchBook");
                List<BookDTO> list = dao.searchBook(searchValue);
                request.setAttribute("LIST_BOOK", list);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error: " + e.getMessage());
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
