package com.fsse2401.Project.data.cart.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.Project.data.cart.entity.CartItemEntity;

import java.math.BigDecimal;

public class CartItemResponseData {

    private int pid;
    private String name;
    @JsonProperty("image_url")
    private String imageUrl;
    private BigDecimal price;
    private int stock;
    @JsonProperty("cart_quantity")
    private int cartQuantity;

    public CartItemResponseData(CartItemEntity entity) {
        this.pid = entity.getProduct().getPid();
        this.name = entity.getProduct().getProductName();
        this.imageUrl = entity.getProduct().getImageUrl();
        this.price = entity.getProduct().getProductPrice();
        this.stock = entity.getProduct().getStock();
        this.cartQuantity = entity.getQuantity(); ;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
}
