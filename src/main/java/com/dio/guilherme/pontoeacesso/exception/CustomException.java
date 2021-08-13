package com.dio.guilherme.pontoeacesso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomException extends Exception{
    
    public CustomException (String string, Long id){
        super(string + " not found with ID " + id);
    }

}