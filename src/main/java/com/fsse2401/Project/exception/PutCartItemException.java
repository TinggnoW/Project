package com.fsse2401.Project.exception;

import com.fsse2401.Project.data.product.entity.ProductEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PutCartItemException extends RuntimeException{
//    public PutCartItemException (ProductEntity productEntity, int quantity){
//        super("Your requested Product:" + productEntity.getProductName() + "/n"+"Quantity:"+quantity+"unavailable");
//    }
}
