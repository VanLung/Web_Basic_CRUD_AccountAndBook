/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lungnv.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import lungnv.utils.DBUtils;

/**
 *
 * @author NGUYEN VAN LUNG SE140193
 */
public class OrderDetailDAO {

    public void insert(CartDTO cart, String orderID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;

        for (BookDTO book : cart.getCart().values()) {
            try {
                conn = DBUtils.getConnection();
                if (conn != null) {
                    String sql = "insert into tblOrderDetail (orderDetailID,orderID,bookID,quantity,price,statusID"
                            + " values(?,?,?,?,?,?)";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, "OrderDetail ");
                    stm.setString(2, orderID);
                    stm.setString(3, book.getBookID());
                    stm.setInt(4, book.getQuantity());
                    stm.setDouble(5, book.getPrice());
                    stm.setString(6, book.getStatusID());

                    stm.executeUpdate();

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
        }
    }
}
