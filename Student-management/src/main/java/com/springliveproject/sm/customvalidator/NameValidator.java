package com.springliveproject.sm.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String>
{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) 
	{
		if(value == null)
	     {
	    	 return false;
	     }
		if(value.matches("[0-9]+"))
		{
			return false;
		 }	
		     return true;
	}

}
