package com.ecosystem.evstationsservice.customexception;

import lombok.Data;

@Data
public class ConflictException extends RuntimeException{

    private String message;

    public ConflictException(String message){
        super(message);

    }
}
