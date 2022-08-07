package com.seb.restapi.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailValidation {

    public String message() default "bad format";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
