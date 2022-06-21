package com.brij.dto.validator;

import com.brij.dto.Employee;
import org.apache.logging.log4j.util.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameValid, Employee> {

    @Override
    public boolean isValid(Employee value, ConstraintValidatorContext context) {
        return Strings.isNotBlank(value.getName()) || (
                Strings.isNotBlank(value.getFirstName()) && Strings.isNotBlank(value.getLastName())
        );
    }
}
