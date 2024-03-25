package com.fsse2401.Project.data.transactionProduct.entity;

import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.product.entity.ProductEntity;
import com.fsse2401.Project.data.transaction.entity.TransactionEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction_product")
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tpid;

    @ManyToOne
    @JoinColumn(name="tid",nullable=false)
    private TransactionEntity transaction;

    @Column(nullable = false)
    private int pid;
    @Column(nullable = false)
    private String name;
    private String description;
    private String imageUrl;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private int stock;
    @Column(nullable = false)
    private int quantity;


    public TransactionProductEntity() {

    }

    public TransactionProductEntity( TransactionEntity transaction, CartItemEntity cartItem ) {
        this.transaction = transaction;
        this.pid = cartItem.getProduct().getPid();
        this.name = cartItem.getProduct().getProductName();
        this.description = cartItem.getProduct().getDescription();
        this.imageUrl = cartItem.getProduct().getImageUrl();
        this.price = cartItem.getProduct().getProductPrice();
        this.stock = cartItem.getProduct().getStock();
        this.quantity = cartItem.getQuantity();
    }

    public int getTpid() {
        return tpid;
    }

    public void setTpid(int tpid) {
        this.tpid = tpid;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
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
