package com.ecosystem.evstationsservice.customexception;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException{
    private String message;

    public NotFoundException(String message){
        super(message);

    }
}
