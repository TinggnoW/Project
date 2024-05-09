package com.fsse2401.Project.data.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.Project.data.transactionProduct.domain.TransactionProductResponseData;

import java.math.BigDecimal;

public class ProductResponseDto {

        private int pid;
        private String productName;
        private String imageUrl;
        private BigDecimal price;
        @JsonProperty("cart_quantity")
        private String description;
        private int stock;

        public ProductResponseDto(int pid, String name, String imageUrl, BigDecimal price, String description, int stock) {
            this.pid = pid;
            this.productName = name;
            this.imageUrl = imageUrl;
            this.price = price;
            this.description = description;
            this.stock = stock;
        }

    public ProductResponseDto(TransactionProductResponseData data) {
        this.pid = data.getPid();
        this.productName = data.getName();
        this.imageUrl = data.getImageUrl();
        this.price = data.getPrice();
        this.description = data.getDescription();
        this.stock = data.getStock();

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

}
