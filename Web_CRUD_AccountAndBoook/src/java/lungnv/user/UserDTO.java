/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lungnv.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author NGUYEN VAN LUNG SE140193
 */
public class UserDTO {

    private String userID;
    private String userName;
    private String password;
    private String phone;
    private String address;
    private String email;
    private String roleID;
    private String statusID;

    public UserDTO() {
    }

    public UserDTO(String userID, String userName, String password, String phone, String address, String email, String roleID, String statusID) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;

        this.roleID = roleID;
        this.statusID = statusID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", userName=" + userName + ", password=" + password + ", phone=" + phone + ", address=" + address + ", email=" + email + ", roleID=" + roleID + ", statusID=" + statusID + '}';
    }

}
