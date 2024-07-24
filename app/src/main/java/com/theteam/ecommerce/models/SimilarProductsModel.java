package com.theteam.ecommerce.models;

public class SimilarProductsModel {
    String productName, businessName, businessFounder, profileImageUrl, productImage;

    public SimilarProductsModel() {
    }

    public SimilarProductsModel(String businessName, String businessFounder, String profileImageUrl, String productImage) {
        this.businessName = businessName;
        this.businessFounder = businessFounder;
        this.profileImageUrl = profileImageUrl;
        this.productImage = productImage;
    }

    public SimilarProductsModel(String productName, String productImage) {
        this.productName = productName;
        this.productImage = productImage;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessFounder() {
        return businessFounder;
    }

    public void setBusinessFounder(String businessFounder) {
        this.businessFounder = businessFounder;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
