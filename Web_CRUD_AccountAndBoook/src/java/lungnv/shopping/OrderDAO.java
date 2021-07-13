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
public class OrderDAO {

    public void insert(OrderDTO order) throws SQLException {

        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert into tblOrders (orderID, userID, address,"
                        + " phone, email, totalMoney, orderDate, statusID, paymentStatus)"
                        + " values(?,?,?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, order.getOrderID());
                stm.setString(2, order.getUserID());
                stm.setString(3, order.getAddress());
                stm.setString(4, order.getPhone());
                stm.setString(5, order.getEmail());
                stm.setDouble(6, order.getTotalMoney());
                stm.setString(7, order.getOrderDate());
                stm.setString(8, order.getStatusID());
                stm.setString(9, order.getPaymentStatus());
                
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
    }
}
