package com.ecosystem.evstationsservice.customexception;

import lombok.Data;

@Data
public class ForbiddenHandleException extends RuntimeException {

    private String message;

    public ForbiddenHandleException(String message){
        super(message);

    }
}

