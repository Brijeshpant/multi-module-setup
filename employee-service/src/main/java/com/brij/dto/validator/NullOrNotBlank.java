package com.brij.dto.validator;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {NullOrNotBlankValidator.class})
@Retention(RUNTIME)
@Target({ FIELD,TYPE})
public @interface NullOrNotBlank {
    String message() default "Invalid field";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
