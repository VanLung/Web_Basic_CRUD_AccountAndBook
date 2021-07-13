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
public class BookDTO {

    private String bookID;
    private String bookName;
    private String description;
    private double price;
    private int quantity;
    private String statusID;
    private String categoryID;
    private String image;

    public BookDTO() {
     
    }

    public BookDTO(String bookID, String bookName, String description, double price, int quantity, String statusID, String categoryID, String image) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.statusID = statusID;
        this.categoryID = categoryID;
        this.image = image;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "BookDTO{" + "bookID=" + bookID + ", bookName=" + bookName + ", description=" + description + ", price=" + price + ", quantity=" + quantity + ", statusID=" + statusID + ", categoryID=" + ", image=" + image + categoryID + '}';
    }

}
