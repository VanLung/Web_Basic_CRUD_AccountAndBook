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
public class CategoryDAO {

    public List<CategoryDTO> getAllCategory() throws SQLException {
        ArrayList<CategoryDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select categoryID, categoryName"
                        + " from tblCategory";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String categoryID = rs.getString("categoryID");
                    String categoryName = rs.getString("categoryName");
                    list.add(new CategoryDTO(categoryID, categoryName));
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

    
    // Test method

//    public static void main(String[] args) throws SQLException {
//        CategoryDAO dao = new CategoryDAO();
//        List<CategoryDTO> listC = dao.getAllCategory();
//        for(CategoryDTO ca : listC){
//            System.out.println(ca);
//        }
//    }
}
