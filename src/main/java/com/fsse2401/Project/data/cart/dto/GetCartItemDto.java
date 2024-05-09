package com.fsse2401.Project.data.cart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.Project.data.cart.domain.CartItemResponseData;
import com.fsse2401.Project.data.product.domain.GetProductResponseData;
import com.fsse2401.Project.data.product.entity.ProductEntity;

import java.math.BigDecimal;

public class GetCartItemDto {

    private int pid;
    private String name;
    @JsonProperty("imageUrl")
    private String imageUrl;
    private BigDecimal price;
    private int stock;
    @JsonProperty("cartQuantity")
    private int cartQuantity;

    public GetCartItemDto(CartItemResponseData data) {
        this.pid = data.getPid();
        this.name = data.getName();
        this.imageUrl = data.getImageUrl();
        this.price = data.getPrice();
        this.stock = data.getStock();
        this.cartQuantity = data.getCartQuantity();
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
