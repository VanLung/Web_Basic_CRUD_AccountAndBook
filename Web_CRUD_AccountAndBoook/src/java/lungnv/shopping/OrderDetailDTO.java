/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lungnv.shopping;

/**
 *
 * @author NGUYEN VAN LUNG SE140193
 */
public class OrderDetailDTO {

    private String orderDetailID;
    private String orderID;
    private String bookID;
    private int quantity;
    private double price;
    private String statusID;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderDetailID, String orderID, String bookID, int quantity, double price, String statusID) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.bookID = bookID;
        this.quantity = quantity;
        this.price = price;
        this.statusID = statusID;
    }

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }
    
    

}
