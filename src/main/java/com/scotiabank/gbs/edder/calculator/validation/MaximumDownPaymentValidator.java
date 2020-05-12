package com.scotiabank.gbs.edder.calculator.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scotiabank.gbs.edder.calculator.model.LoanData;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class MaximumDownPaymentValidator
    implements ConstraintValidator<MaximumDownPayment, Object[]> {
      
  private static final Logger LOGGER = LoggerFactory.getLogger(MaximumDownPaymentValidator.class);

  @Override
  public boolean isValid(Object[] value, ConstraintValidatorContext context) {
    LOGGER.info("Starting validation of {}", value);
    if (value[0] == null) {
      throw new IllegalArgumentException("Sent parameters don't coincide with expected");
    }

    if (!(value[0] instanceof LoanData)) {
      return false;
    }
    System.out.println("value[0]: " + value[0]);
    LoanData data = (LoanData) value[0];
    return data.getDownPayment() < (data.getPropertyPrice()/10);
  }

}
