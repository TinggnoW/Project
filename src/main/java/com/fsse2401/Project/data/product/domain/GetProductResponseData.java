package com.fsse2401.Project.data.product.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.Project.data.product.entity.ProductEntity;

import java.math.BigDecimal;

public class GetProductResponseData {
    private int pid;
    @JsonProperty("name")
    private String productName;
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("price")
    private BigDecimal productPrice;
    private Integer stock;

    public GetProductResponseData(ProductEntity entity) {
        this.pid = entity.getPid();
        this.productName = entity.getProductName();
        this.description = entity.getDescription();
        this.imageUrl = entity.getImageUrl();
        this.productPrice = entity.getProductPrice();
        this.stock=entity.getStock();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


}
