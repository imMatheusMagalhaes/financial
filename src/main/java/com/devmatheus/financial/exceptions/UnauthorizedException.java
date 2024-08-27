package com.devmatheus.financial.exceptions;

public class UnauthorizedException extends RuntimeException {
  public UnauthorizedException(){
      super("unauthorized");
  }
}
