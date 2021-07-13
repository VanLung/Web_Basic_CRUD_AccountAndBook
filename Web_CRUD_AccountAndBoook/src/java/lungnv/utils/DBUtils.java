/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lungnv.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NGUYEN VAN LUNG SE140193
 */
public class DBUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShop";
            conn = DriverManager.getConnection(url, "sa", "123");
            return conn;
        } catch (Exception e) {
        }
        return null;
    }
    
    
    //Test Connection
//    public static void main(String[] args) {
//        try {
//            System.out.println(getConnection());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    
}
