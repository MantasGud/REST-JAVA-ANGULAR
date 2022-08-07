package com.seb.restapi.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelNumberValidator implements ConstraintValidator<TelNumberValidation, Long>{

	public boolean isValid(Long nr, ConstraintValidatorContext cxt) {

		try {
			
			if(nr == null) {
	            return false;
	        } 
			
			if (nr.toString().length() < 9) {
				return false;
			}
			
			if (nr.toString().length() > 11) {
				return false;
			}
			
			
		} catch (NumberFormatException e) {
			return false;
		}
		
		
		return true;
    		
    }

}
