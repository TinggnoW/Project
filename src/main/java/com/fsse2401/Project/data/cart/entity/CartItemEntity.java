package com.fsse2401.Project.data.cart.entity;

import com.fsse2401.Project.data.product.entity.ProductEntity;
import com.fsse2401.Project.data.user.entity.UserEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "Cart_item")
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    @ManyToOne
    @JoinColumn(name="pid",nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "uid",nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    private int quantity;

    public CartItemEntity( ProductEntity product, UserEntity user, int quantity) {
        this.product = product;
        this.user = user;
        this.quantity = quantity;
    }

    public CartItemEntity() {

    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
