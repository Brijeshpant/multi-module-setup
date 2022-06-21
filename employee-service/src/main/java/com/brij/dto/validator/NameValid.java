package com.brij.dto.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {NameValidator.class})
@Retention(RUNTIME)
@Target(TYPE)
public @interface NameValid {
    String message() default "Either name or first name and last name are required";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
