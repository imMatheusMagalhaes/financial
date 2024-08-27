package com.devmatheus.financial.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Object id){
        super("Not found. id = " + id);
    }
}
