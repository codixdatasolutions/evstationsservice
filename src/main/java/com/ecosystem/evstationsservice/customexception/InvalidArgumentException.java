package com.ecosystem.evstationsservice.customexception;

import lombok.Data;

@Data
public class InvalidArgumentException  extends  RuntimeException{

    private String message;

    public InvalidArgumentException(String message){
        super(message);

    }
}
