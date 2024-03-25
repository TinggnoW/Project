package com.fsse2401.Project.service;

import com.fsse2401.Project.data.product.domain.GetProductResponseData;
import com.fsse2401.Project.data.product.entity.ProductEntity;

import java.util.List;

public interface ProductService  {

    List<GetProductResponseData> getProduct();

    GetProductResponseData getProductbyid(int id);

    ProductEntity getEntityByPid(int pid);


    boolean deductProduct(int pid, int amount);

//    boolean isValidQuantity(Integer quantity);

    boolean isValidQuantity(Integer quantity);

    boolean isValidQuantity(ProductEntity entity, Integer quantity);

    boolean isValidQuantity(int pid, Integer quantity);
}
