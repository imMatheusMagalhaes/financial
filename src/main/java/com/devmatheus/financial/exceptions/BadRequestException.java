package com.devmatheus.financial.exceptions;

public class BadRequestException extends RuntimeException {
  public BadRequestException(String msg) {
    super(msg);
  }
}
