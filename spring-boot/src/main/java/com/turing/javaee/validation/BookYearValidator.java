package com.turing.javaee.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.turing.javaee.model.*;

public class BookYearValidator implements ConstraintValidator<BookYearValidation, Book> {

	 @Override
    public void initialize(BookYearValidation constraint) {
    }
	 
	 
	@Override
	public boolean isValid(Book value, ConstraintValidatorContext context) {
		if( value.getCategory() == 1L)//Technology
		{
			if(value.getYear() ==null)
			{
				return false;
			}
			else
			{
				Integer year = 0;
				try
				{
					 year = Integer.parseInt(value.getYear());
				}
				catch(Exception e)
				{
					return false;
				}
				return year >= 2000;
			}
		}
		return true;
	}

}
