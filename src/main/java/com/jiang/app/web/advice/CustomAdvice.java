package com.jiang.app.web.advice;

import com.jiang.app.exception.ServiceException;
import com.jiang.app.dto.ErrorResp;
import com.jiang.app.dto.FieldValidError;
import com.jiang.app.dto.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    String message = messageSource.getMessage(ex.getCode(), null, LocaleContextHolder.getLocale());
    errorResp.setMessage(message);
    errorResp.setCode(ex.getCode());
    return new ResponseEntity<>(new Resp(errorResp, HttpStatus.CONFLICT), HttpStatus.CONFLICT);
  }
}
