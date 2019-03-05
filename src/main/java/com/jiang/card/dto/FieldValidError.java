package com.jiang.card.dto;

import lombok.Data;

@Data
final public class FieldValidError implements GenericError {
  private String field;
  private String message;
  private Object rejectedValue;

  public FieldValidError(String field, String message, Object rejectedValue) {
    this.field = field;
    this.message = message;
    this.rejectedValue = rejectedValue;
  }
}
