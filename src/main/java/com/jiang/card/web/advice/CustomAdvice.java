package com.jiang.card.web.advice;

import com.jiang.card.exception.ServiceException;
import com.jiang.card.dto.ErrorResp;
import com.jiang.card.dto.FieldValidError;
import com.jiang.card.dto.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class CustomAdvice {
  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler(ServiceException.class)
  public ResponseEntity<Object> serviceException(ServiceException ex) {
    ErrorResp<FieldValidError> errorResp = new ErrorResp<>();
    String message = messageSource.getMessage(ex.getCode(), null, Locale.ENGLISH);
    errorResp.setMessage(message);
    errorResp.setCode(ex.getCode());
    return new ResponseEntity<>(new Resp(errorResp, HttpStatus.CONFLICT), HttpStatus.CONFLICT);
  }
}
