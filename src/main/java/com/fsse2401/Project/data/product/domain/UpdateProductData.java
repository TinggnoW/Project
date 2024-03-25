package com.fsse2401.Project.data.product.domain;

import com.fsse2401.Project.data.product.dto.UpdateProductDto;

import java.math.BigDecimal;

public class UpdateProductData {
    private int pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private int cartQuantity;
    private int stock;

    public UpdateProductData(UpdateProductDto dto) {
        this.pid = dto.getPid();
        this.name = dto.getName();
        this.imageUrl = dto.getImageUrl();
        this.price = dto.getPrice();
        this.cartQuantity = dto.getCartQuantity();
        this.stock = dto.getStock();
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
