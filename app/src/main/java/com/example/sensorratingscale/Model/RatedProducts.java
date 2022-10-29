package com.example.sensorratingscale.Model;

public class RatedProducts {
    private String userEmail;
    private int productId;
    private String productName;
    private String timestamp;
    private int givenRating;

    public RatedProducts() {
    }

    public RatedProducts(
            String userEmail,
            int productId,
            String productName,
            String timestamp,
            int givenRating) {
        this.userEmail = userEmail;
        this.productId = productId;
        this.productName = productName;
        this.timestamp = timestamp;
        this.givenRating = givenRating;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getGivenRating() {
        return givenRating;
    }

    public void setGivenRating(int givenRating) {
        this.givenRating = givenRating;
    }
}
