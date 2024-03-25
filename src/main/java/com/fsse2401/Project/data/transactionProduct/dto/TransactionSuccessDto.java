package com.fsse2401.Project.data.transactionProduct.dto;

public class TransactionSuccessDto {
    private String result;
    public TransactionSuccessDto(){
        result = "SUCCESS";
    }
    public String getResult(){
        return result;
    }

    private void setResult (String result){}
}
