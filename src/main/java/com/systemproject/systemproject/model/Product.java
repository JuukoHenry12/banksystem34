package com.systemproject.systemproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer prodId;
    private String productName;
    private double price;

    public Product(){
        
    }
    
    public Product(Integer prodId, String productName, double price) {
        this.prodId = prodId;
        this.productName = productName;
        this.price = price;
    }
    public Integer getProdId() {
        return prodId;
    }
    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
   
}
