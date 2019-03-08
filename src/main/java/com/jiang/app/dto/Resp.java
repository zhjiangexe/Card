package com.jiang.app.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
final public class Resp<T> {
  private HttpStatus status;
  private String message;
  private T data;
  private ErrorResp error;

  public Resp(T data, HttpStatus status) {
    this.data = data;
    this.status = status;
  }

  public Resp(T data, String message, HttpStatus status) {
    this.data = data;
    this.message = message;
    this.status = status;
  }

  public Resp(ErrorResp error, HttpStatus status) {
    this.status = status;
    this.error = error;
  }

  private static ResponseEntity<Resp> generalOK(Resp<Object> objectResp, HttpStatus httpStatus) {
    return new ResponseEntity<>(objectResp, httpStatus);
  }

  private static ResponseEntity<Resp> generalOK(Resp<Object> resp) {
    return generalOK(resp, HttpStatus.OK);
  }

  public static ResponseEntity<Resp> success(Object obj, String msg) {
    Resp<Object> objectResp = new Resp<>(obj, msg, HttpStatus.OK);
    return generalOK(objectResp);
  }

  public static ResponseEntity<Resp> success(Object obj) {
    Resp<Object> objectResp = new Resp<>(obj, HttpStatus.OK);
    return generalOK(objectResp);
  }

  public static ResponseEntity<Resp> success(Object obj, HttpStatus httpStatus) {
    Resp<Object> objectResp = new Resp<>(obj, httpStatus);
    return generalOK(objectResp, httpStatus);
  }

}
