package com.springliveproject.sm.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class phoneValidator implements ConstraintValidator<Phone, Long>
{
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) 
	{
		     if(value == null)
		     {
		    	 return false;
		     }
		    String number =  String.valueOf(value);
		    int length = number.length();
		    if(length != 10)
		    {
		          return false;
		    }
		    if(number.matches("[0-9]"))
		    {
		    	 return true;
		    }
		    return true;
	}

}
