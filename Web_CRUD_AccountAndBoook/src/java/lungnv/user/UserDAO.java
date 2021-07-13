/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lungnv.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lungnv.shopping.BookDTO;
import lungnv.utils.DBUtils;

/**
 *
 * @author NGUYEN VAN LUNG SE140193
 */
public class UserDAO {

    UserDTO user = null;
    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public UserDTO checkLogin(String userID, String password) throws SQLException {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select userName,phone,address,email, roleID,statusID"
                        + " from tblUsers"
                        + " where userID = ? and password = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String userName = rs.getString("userName");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    String email = rs.getString("email");

                    String roleID = rs.getString("roleID");
                    String statusID = rs.getString("statusID");
                    user = new UserDTO(userID, userName, "", phone, address, email, roleID, statusID);
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
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select  userID,userName,phone,address,email, roleID,statusID"
                        + " from tblUsers"
                        + " where userName like ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String userName = rs.getString("userName");
                    String password = "***";
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    String email = rs.getString("email");

                    String roleID = rs.getString("roleID");
                    String statusID = rs.getString("statusID");
                    list.add(new UserDTO(userID, userName, password, phone, address, email, roleID, statusID));
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

    public boolean deleteUser(String userID) throws SQLException {
        boolean result = false;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "delete tblUsers"
                        + " where userID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
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

    public boolean updateUser(UserDTO user) throws SQLException {
        boolean check = false;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "update tblUsers"
                        + " set userName = ?,phone = ?,address=?,email = ?,roleID = ?,statusID = ?"
                        + " where userID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserName());
                stm.setString(2, user.getPhone());
                stm.setString(3, user.getAddress());
                stm.setString(4, user.getEmail());
                stm.setString(5, user.getRoleID());
                stm.setString(6, user.getStatusID());
                stm.setString(7, user.getUserID());

                check = stm.executeUpdate() > 0;
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
        return check;
    }

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select userID"
                        + " from tblUsers"
                        + " where userID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
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

    public boolean insert(UserDTO user) throws SQLException {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert into tblUsers(userID, userName, password, phone, address, email, roleID, statusID)"
                        + " values(?,?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getUserName());
                stm.setString(3, user.getPassword());
                stm.setString(4, user.getPhone());
                stm.setString(5, user.getAddress());
                stm.setString(6, user.getEmail());
                stm.setString(7, user.getRoleID());
                stm.setString(8, user.getStatusID());

                check = stm.executeUpdate() > 0;
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
        return check;
    }

    // Test method
//    public static void main(String[] args) {
//        try {
//            System.out.println(new UserDAO().getListUser("a"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
