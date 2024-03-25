package com.fsse2401.Project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException (int tid,String firebaseUid){
        super(String.format("Transactoin not found-tid:%d,firebaseUid:%s",tid,firebaseUid));

    }

}
