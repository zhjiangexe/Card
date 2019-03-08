package com.jiang.app.exception;

public class ServiceException extends RuntimeException {
  private String code;

  public ServiceException(String code) {
    super(code);
    this.code = code;
  }

  public ServiceException(String message, String code) {
    super(message);
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
