package com.ecosystem.evstationsservice.customexception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldError {

    private  String field;

    private  String defaultMessage;


    public FieldError(org.springframework.validation.FieldError fieldError) {
        this.field = fieldError.getField();
        this.defaultMessage = fieldError.getDefaultMessage();
    }
}