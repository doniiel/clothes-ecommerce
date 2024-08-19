package com.e_commerce.clothes.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
public class MyException {

    private String message;
    private Map<String, String> errors;

    public MyException(String message) {
        this.message = message;
    }
}
