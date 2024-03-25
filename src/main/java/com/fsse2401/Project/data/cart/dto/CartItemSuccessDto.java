package com.fsse2401.Project.data.cart.dto;

public class CartItemSuccessDto {
    private String result;
    public  CartItemSuccessDto(){
        result = "SUCCESS";
    }
    public String getResult(){
        return result;
    }

    private void setResult (String result){}
}
