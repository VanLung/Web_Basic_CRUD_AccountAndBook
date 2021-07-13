/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lungnv.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lungnv.utils.DBUtils;

/**
 *
 * @author NGUYEN VAN LUNG SE140193
 */
public class BookDAO {

    public List<BookDTO> getAllBook() throws SQLException {
        List<BookDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select bookID, bookName,  description, price, "
                        + " quantity, statusID, categoryID,image"
                        + " from tblBooks";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookName = rs.getString("bookName");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String statusID = rs.getString("statusID");
                    String categoryID = rs.getString("categoryID");
                    String image = rs.getString("image");
                    list.add(new BookDTO(bookID, bookName, description, price, quantity, statusID, categoryID, image));

                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public ArrayList<BookDTO> getAllBookForUser() throws SQLException {
        ArrayList<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select bookID, bookName,description, price, quantity, statusID,categoryID,image"
                        + " from tblBooks";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookName = rs.getString("bookName");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String statusID = rs.getString("statusID");
                    String categoryID = rs.getString("categoryID");
                    String image = rs.getString("image");
                    if (quantity != 0) {
                        list.add(new BookDTO(bookID, bookName, description, price, quantity, statusID, categoryID, image));
                    }

                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<BookDTO> searchBook(String searchValue) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select bookID, bookName,description, price, quantity, statusID,categoryID,image"
                        + " from tblBooks"
                        + " where bookName like ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookName = rs.getString("bookName");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String statusID = rs.getString("statusID");
                    String categoryID = rs.getString("categoryID");
                    String image = rs.getString("image");
                    list.add(new BookDTO(bookID, bookName, description, price, quantity, statusID, categoryID, image));
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }

    public ArrayList<Integer> getQuantity(CartDTO cart) throws SQLException {
        ArrayList<Integer> listQ = new ArrayList<Integer>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        for (BookDTO product : cart.getCart().values()) {
            try {
                conn = DBUtils.getConnection();
                if (conn != null) {
                    String sql = "select quantity"
                            + " from tblBooks"
                            + " where bookID = ?";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, product.getBookID());
                    rs = stm.executeQuery();
                    if (rs.next()) {
                        int quantity = rs.getInt("quantity");
                        listQ.add(quantity);
                    }
                }
            } catch (Exception e) {

            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        }

        return listQ;
    }

    public ArrayList<String> checkQuantity(CartDTO cart) throws SQLException {
        ArrayList<Integer> listQ = getQuantity(cart);
        ArrayList<String> listError = new ArrayList<String>();
        int count = 0;

        for (BookDTO book : cart.getCart().values()) {
            if (listQ.get(count) < book.getQuantity()) {
                listError.add((book.getBookName() + " is not enough(" + listQ.get(count) + ")"));
            }
            count++;
        }
        return listError;
    }

    public List<BookDTO> getBookByID(String ID) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select bookID, bookName,description, price, quantity, statusID,categoryID,image "
                        + " from tblBooks"
                        + " where categoryID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, ID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookName = rs.getString("bookName");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String statusID = rs.getString("statusID");
                    String categoryID = rs.getString("categoryID");
                    String image = rs.getString("image");

                    list.add(new BookDTO(bookID, bookName, description, price, quantity, statusID, categoryID, image));
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return list;
    }

    public boolean insertBook(BookDTO book) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert tblBooks(bookID,bookName,description,price,quantity,statusID,categoryID,image)"
                        + " values(?, ?, ?, ?, ?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, book.getBookID());
                stm.setString(2, book.getBookName());
                stm.setString(3, book.getDescription());
                stm.setDouble(4, book.getPrice());
                stm.setInt(5, book.getQuantity());
                stm.setString(6, book.getStatusID());
                stm.setString(7, book.getCategoryID());
                stm.setString(8, book.getImage());
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return check;
    }

    public boolean updateBook(BookDTO book) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "update tblBooks"
                        + " set bookName = ?,description = ? , price = ? , quantity = ? , statusID = ? ,categoryID = ?,image = ?"
                        + " where bookID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, book.getBookName());
                stm.setString(2, book.getDescription());
                stm.setDouble(3, book.getPrice());
                stm.setInt(4, book.getQuantity());
                stm.setString(5, book.getStatusID());
                stm.setString(6, book.getCategoryID());
                stm.setString(7, book.getImage());
                stm.setString(8, book.getBookID());

                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean deleteBook(String bookID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "delete tblBooks"
                        + " where bookID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, bookID);
                stm.executeUpdate();
                int value = stm.executeUpdate();
                result = value > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public ArrayList<String> getAllBookID() throws SQLException {
        ArrayList<String> listID = new ArrayList<String>();

        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select bookID"
                        + " from tblBooks";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    listID.add(bookID);

                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listID;
    }

    public double getPrice(CartDTO cart) {
        double total = 0;

        for (BookDTO book : cart.getCart().values()) {
            total = total + (book.getPrice() * book.getQuantity());
        }

        return total;
    }

    public void updateQuantity(CartDTO cart) throws SQLException {
        ArrayList<Integer> quantityList = getQuantity(cart);
        int result;
        int count = 0;
        Connection conn = null;
        PreparedStatement stm = null;

        for (BookDTO book : cart.getCart().values()) {
            result = quantityList.get(count) - book.getQuantity();
            try {
                conn = DBUtils.getConnection();
                if (conn != null) {
                    String sql = "update tblBooks"
                            + " set quantity = ? "
                            + " where bookID = ?";
                    stm = conn.prepareStatement(sql);
                    stm.setInt(1, result);
                    stm.setString(2, book.getBookID());
                    stm.executeUpdate();
                }
            } catch (Exception e) {

            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            count++;
        }

    }

    public String checkCreateBook(BookDTO book) throws SQLException {
        ArrayList<String> listID = getAllBookID();
        Boolean check = true;
        String errorMessage = "";

        for (int i = 0; i < listID.size(); i++) {
            if (book.getBookID().equals(listID.get(i))) {
                check = false;
            }
        }

        if (!check) {
            errorMessage += "Duplicate Book ID\n";
        }
        if (book.getBookName().equals("") || book.getBookName().length() > 50) {
            errorMessage += "Name is not null and length [1,50]\n";
        }
        if (book.getDescription().equals("") || book.getDescription().length() > 50) {
            errorMessage += "Description is not null and length [1,50] \n";
        }
        if (book.getPrice() <= 0) {
            errorMessage += "Price must be > 0\n";
        }
        if (book.getQuantity() <= 0) {
            errorMessage += "Quantity must be > 0\n";
        }
        if (book.getStatusID().equals("") || book.getStatusID().length() > 10) {
            errorMessage += "Status ID is not null and length [1,10]\n";
        }

        if (book.getCategoryID().equals("") || book.getCategoryID().length() > 10) {
            errorMessage += "Category ID is not null and length [1,10]\n";
        }
        if (book.getImage().equals("")) {
            errorMessage += "Image is not null\n";
        }
        return errorMessage;
    }

    public String checkUpdateBook(BookDTO book) {
        String errorMessage = "";

        if (book.getBookName().equals("") || book.getBookName().length() > 50) {
            errorMessage += "Name is not null and length [1,50]\n";
        }
        if (book.getDescription().equals("") || book.getDescription().length() > 50) {
            errorMessage += "Description is not null and length [1,50] \n";
        }
        if (book.getPrice() <= 0) {
            errorMessage += "Price must be > 0\n";
        }
        if (book.getQuantity() <= 0) {
            errorMessage += "Quantity must be > 0\n";
        }
        if (book.getStatusID().equals("") || book.getStatusID().length() > 10) {
            errorMessage += "Status ID is not null and length [1,10]\n";
        }

        if (book.getCategoryID().equals("") || book.getCategoryID().length() > 10) {
            errorMessage += "Category ID is not null and length [1,10]\n";
        }
        if (book.getImage().equals("")) {
            errorMessage += "Image is not null\n";
        }
        return errorMessage;
    }

    public boolean checkDuplicate(String bookID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select bookID"
                        + " from tblBooks"
                        + " where bookID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, bookID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public List<BookDTO> getBookByCategoryID(String categoryID) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select bookID, bookName,  description, price, "
                        + " quantity, statusID, categoryID,image"
                        + " from tblBooks"
                        + " where categoryID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, categoryID);
                rs = stm.executeQuery();
                while (rs.next()) {

                    list.add(new BookDTO(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    
    public BookDTO getBookByIDForDetail(String ID) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select bookID, bookName,description, price, quantity, statusID,categoryID,image "
                        + " from tblBooks"
                        + " where bookID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, ID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookName = rs.getString("bookName");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    String statusID = rs.getString("statusID");
                    String categoryID = rs.getString("categoryID");
                    String image = rs.getString("image");

                    return new BookDTO(bookID, bookName, description, price, quantity, statusID, categoryID, image);
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return null;
    }

//    Test method
//    public static void main(String[] args) {
//        try {
//            System.out.println(new BookDAO().searchBook("a"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
