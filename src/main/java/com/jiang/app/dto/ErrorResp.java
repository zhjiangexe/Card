package com.jiang.app.dto;

import lombok.Data;

import java.util.List;

@Data
final public class ErrorResp<E extends GenericError> {
  private String code;
  private String message;
  private List<E> errors;
}
