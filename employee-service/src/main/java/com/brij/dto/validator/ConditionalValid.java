package com.brij.dto.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {ConditionalValidator.class})
@Repeatable(ConditionalValid.List.class)
public @interface ConditionalValid {
    String message() default "Invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field();

    String[] dependentFields();

    boolean mExclusive() default true;

    @Target({TYPE})
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        ConditionalValid[] value();
    }
}
