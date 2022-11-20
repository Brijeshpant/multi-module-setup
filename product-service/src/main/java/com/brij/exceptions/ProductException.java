package com.brij.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductException extends RuntimeException {
    private String code;

    public ProductException(String code, String message) {
        super(message);
        this.code = code;
    }
}
