package com.fsse2401.Project.data.transactionProduct.dto;

import com.fsse2401.Project.data.product.dto.ProductResponseDto;
import com.fsse2401.Project.data.transactionProduct.domain.TransactionProductResponseData;

import java.math.BigDecimal;

public class TransactionProductResponseDto {

    private int tpid;
    private ProductResponseDto product;
    private int quantity;
    private BigDecimal subtotal;

    public TransactionProductResponseDto(TransactionProductResponseData data) {
        this.tpid = data.getTpid();
        this.product = new ProductResponseDto(data);
        this.quantity = data.getQuantity();
        this.subtotal = data.getPrice().multiply(new BigDecimal(data.getQuantity()));
    }

    public int getTpid() {
        return tpid;
    }

    public void setTpid(int tpid) {
        this.tpid = tpid;
    }

    public ProductResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductResponseDto product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
