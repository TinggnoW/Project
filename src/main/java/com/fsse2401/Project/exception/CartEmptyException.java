package com.fsse2401.Project.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartEmptyException extends RuntimeException{
    public CartEmptyException () {
        super("Your Cart is empty now");
    }

}
