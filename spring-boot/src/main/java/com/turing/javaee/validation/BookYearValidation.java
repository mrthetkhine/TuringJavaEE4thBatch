package com.turing.javaee.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {BookYearValidator.class})
public @interface BookYearValidation {
	String message() default "Invalid Year for technology";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
