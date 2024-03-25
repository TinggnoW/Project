package com.fsse2401.Project.exception;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PayTransactionException extends RuntimeException{
    public PayTransactionException (String message){
        super(message);
    }
}
