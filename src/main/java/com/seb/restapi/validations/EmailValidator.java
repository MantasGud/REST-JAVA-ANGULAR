package com.seb.restapi.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValidation, String>
{
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
    	Pattern emailRegex = 
    		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    	
    	if (email != null) {
    		Matcher matcher = emailRegex.matcher(email);
            return matcher.find();
    	} else {
    		return true;
    	}
    	
    	 

    }
}
