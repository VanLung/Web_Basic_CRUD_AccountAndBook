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
public class BookError {
    private String bookIDError;
    private String bookNameError;
    private String descriptionError;
    private double priceError;
    private int quantityError;
    private String statusIDError;
    private String imageError;
    private String categoryIDError;

    public BookError() {
    }

    public BookError(String bookIDError, String bookNameError, String descriptionError, double priceError, int quantityError, String statusIDError, String imageError, String categoryIDError) {
        this.bookIDError = bookIDError;
        this.bookNameError = bookNameError;
        this.descriptionError = descriptionError;
        this.priceError = priceError;
        this.quantityError = quantityError;
        this.statusIDError = statusIDError;
        this.imageError = imageError;
        this.categoryIDError = categoryIDError;
    }

    public String getBookIDError() {
        return bookIDError;
    }

    public void setBookIDError(String bookIDError) {
        this.bookIDError = bookIDError;
    }

    public String getBookNameError() {
        return bookNameError;
    }

    public void setBookNameError(String bookNameError) {
        this.bookNameError = bookNameError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public double getPriceError() {
        return priceError;
    }

    public void setPriceError(double priceError) {
        this.priceError = priceError;
    }

    public int getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(int quantityError) {
        this.quantityError = quantityError;
    }

    public String getStatusIDError() {
        return statusIDError;
    }

    public void setStatusIDError(String statusIDError) {
        this.statusIDError = statusIDError;
    }

 

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public String getCategoryIDError() {
        return categoryIDError;
    }

    public void setCategoryIDError(String categoryIDError) {
        this.categoryIDError = categoryIDError;
    }

    @Override
    public String toString() {
        return "BookError{" + "bookIDError=" + bookIDError + ", bookNameError=" + bookNameError + ", descriptionError=" + descriptionError + ", priceError=" + priceError + ", quantityError=" + quantityError + ", statusIDError=" + statusIDError +   ", imageError=" + imageError + ", categoryIDError=" + categoryIDError + '}';
    }
    
    
    
    
}
