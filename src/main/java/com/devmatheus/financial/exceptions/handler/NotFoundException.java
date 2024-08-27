package com.devmatheus.financial.exceptions.handler;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Object id){
        super("Not found. id = " + id);
    }
}
