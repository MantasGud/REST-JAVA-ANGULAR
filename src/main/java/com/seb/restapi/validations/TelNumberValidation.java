package com.seb.restapi.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = TelNumberValidator.class)
public @interface TelNumberValidation {
	
	public String message() default " - Please enter a correct number. Number must only be digits and be between 8 and 12 digits";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}

