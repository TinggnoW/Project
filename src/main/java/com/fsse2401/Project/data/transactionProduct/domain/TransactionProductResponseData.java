package com.fsse2401.Project.data.transactionProduct.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.transaction.TransactionStatus;
import com.fsse2401.Project.data.transaction.entity.TransactionEntity;
import com.fsse2401.Project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.Project.data.user.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionProductResponseData {

    private int tpid;
    private TransactionEntity transaction;
    private int pid;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private int stock;
    private int quantity;


    public TransactionProductResponseData(TransactionProductEntity entity) {
        this.tpid = entity.getTpid();
        this.pid = entity.getPid();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.imageUrl = entity.getImageUrl();
        this.price = entity.getPrice();
        this.stock = entity.getStock();
        this.quantity = entity.getQuantity();
    }

    public int getTpid() {
        return tpid;
    }

    public void setTpid(int tpid) {
        this.tpid = tpid;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

