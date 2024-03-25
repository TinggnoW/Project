package com.fsse2401.Project.data.product.dto;

import com.fsse2401.Project.data.product.domain.GetProductResponseData;

import java.math.BigDecimal;

public class GetProductResponseDto {
    private int pid;
    private String productName;
    private String imageUrl;
    private BigDecimal productPrice;
    private boolean hasStock;




    public GetProductResponseDto(GetProductResponseData data) {
        this.pid = data.getPid();
        this.productName = data.getProductName();
        this.productPrice = data.getProductPrice();
        this.imageUrl = data.getImageUrl();
        this.hasStock = data.getStock()>0;
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

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isHasStock() {
        return hasStock;
    }

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }
}
