package com.fsse2401.Project.exception;

import com.fsse2401.Project.data.cart.entity.CartItemEntity;
import com.fsse2401.Project.data.product.entity.ProductEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException (){
        super("Your requested Product is not found" );
    }
}
