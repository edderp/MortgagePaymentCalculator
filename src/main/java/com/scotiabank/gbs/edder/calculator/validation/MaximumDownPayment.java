package com.scotiabank.gbs.edder.calculator.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = MaximumDownPaymentValidator.class)
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE,
    ElementType.TYPE_PARAMETER, ElementType.TYPE_USE, ElementType.ANNOTATION_TYPE,
    ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MaximumDownPayment {

  String message() default "Downpayment cannot be higher than 10% of the property purchase price";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
