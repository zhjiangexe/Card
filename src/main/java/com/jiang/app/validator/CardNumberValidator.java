package com.jiang.app.validator;

import com.jiang.app.util.CardValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardNumberValidator implements ConstraintValidator<CardNumber, String> {
  @Override
  public void initialize(CardNumber constraintAnnotation) {

  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return CardValidator.validateLuhn(value);
  }
}
