/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lungnv.user;

/**
 *
 * @author NGUYEN VAN LUNG SE140193
 */
public class UserError {

    private String userIDError;
    private String userNameError;
    private String passwordError;
    private String phoneError;
    private String addressError;
    private String emailError;
    private String roleIDError;
    private String statusIDError;
    private String confirmPwError;
    private String messageError;

    public UserError() {
    }

    public UserError(String userIDError, String userNameError, String passwordError, String phoneError, String addressError, String emailError, String roleIDError, String statusIDError, String confirmPwError, String messageError) {
        this.userIDError = userIDError;
        this.userNameError = userNameError;
        this.passwordError = passwordError;
        this.phoneError = phoneError;
        this.addressError = addressError;
        this.emailError = emailError;
        this.roleIDError = roleIDError;
        this.statusIDError = statusIDError;
        this.confirmPwError = confirmPwError;
        this.messageError = messageError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getStatusIDError() {
        return statusIDError;
    }

    public void setStatusIDError(String statusIDError) {
        this.statusIDError = statusIDError;
    }

    public String getConfirmPwError() {
        return confirmPwError;
    }

    public void setConfirmPwError(String confirmPwError) {
        this.confirmPwError = confirmPwError;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    @Override
    public String toString() {
        return "UserError{" + "userIDError=" + userIDError + ", userNameError=" + userNameError + ", passwordError=" + passwordError + ", phoneError=" + phoneError + ", addressError=" + addressError + ", emailError=" + emailError + ", roleIDError=" + roleIDError + ", statusIDError=" + statusIDError + ", confirmPwError=" + confirmPwError + ", messageError=" + messageError + '}';
    }

    
    
}