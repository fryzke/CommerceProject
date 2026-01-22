package com.example.commerce;

public class Product {
    private String productName;
    private int price;
    private String details;
    private int stock;
    //생성자
    public Product(String productName, int price, String details, int stock) {
        this.productName = productName;
        this.price = price;
        this.details = details;
        this.stock = stock;
    }

    //getter
    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getDetails() {
        return details;
    }

    public int getStock() {
        return stock;
    }
    //setter
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
