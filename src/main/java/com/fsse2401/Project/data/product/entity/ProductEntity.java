package com.fsse2401.Project.data.product.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @Column (name="Product_Name",nullable = false)
    private String productName;

    @Column (name = "Product_Price",nullable = false)
    private BigDecimal productPrice;

    @Column (name = "Image_Url",nullable = false)
    private String imageUrl;

    @Column(name = "Description")
    private String description;

    @Column(name = "Stock", nullable = false)
    private int stock;

    @ManyToMany
    private List<ProductEntity> productEntities;

    public ProductEntity(int pid, String productName, BigDecimal productPrice, String imageUrl, String description, int stock, List<ProductEntity> productEntities) {
        this.pid = pid;
        this.productName = productName;
        this.productPrice = productPrice;
        this.imageUrl = imageUrl;
        this.description = description;
        this.stock = stock;
        this.productEntities = productEntities;
    }

    public ProductEntity() {

    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }
}
