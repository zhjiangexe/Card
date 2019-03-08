package com.jiang.app.web.advice;

import com.jiang.app.dto.ErrorResp;
import com.jiang.app.dto.FieldValidError;
import com.jiang.app.dto.Resp;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

import static java.util.stream.Collectors.toList;

@ControllerAdvice
public class GlobalAdvice extends ResponseEntityExceptionHandler {

  private static final String IV_100001 = "IV100001";
  private static final String INPUT_VALIDATE_ERROR = "INPUT VALIDATE ERROR";

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    BindingResult bindingResult = ex.getBindingResult();
    List<ObjectError> allErrors = bindingResult.getAllErrors();
    List<FieldValidError> list = allErrors.stream()
        .filter(e -> e instanceof FieldError)
        .map(e -> (FieldError) e)
        .map(e -> new FieldValidError(e.getField(), e.getDefaultMessage(), e.getRejectedValue()))
        .collect(toList());
    ErrorResp<FieldValidError> errorResp = new ErrorResp<>();
    errorResp.setErrors(list);
    errorResp.setMessage(INPUT_VALIDATE_ERROR);
    errorResp.setCode(IV_100001);
    return new ResponseEntity<>(new Resp(errorResp, HttpStatus.BAD_REQUEST), headers, status);
  }

}