package com.brij.dto.validator;

import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.util.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConditionalValidator implements ConstraintValidator<ConditionalValid, Object> {
    private String field;
    private String[] dependentFields;
    private boolean mExclusive;

    @Override
    public void initialize(ConditionalValid constraintAnnotation) {
        field = constraintAnnotation.field();
        dependentFields = constraintAnnotation.dependentFields();
        mExclusive = constraintAnnotation.mExclusive();
        ConstraintValidator.super.initialize(constraintAnnotation);

    }

    @SneakyThrows
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String field = BeanUtils.getProperty(value, this.field);
        if (mExclusive) {
            return Strings.isNotBlank(field) || areDependentFieldsNonBlank(value, dependentFields);
        } else if (Strings.isNotBlank(field)) {
            return areDependentFieldsNonBlank(value, dependentFields);
        }
        return true;
    }

    private boolean areDependentFieldsNonBlank(Object value, String[] dependentFields) {
        return Arrays.stream(dependentFields).noneMatch(s ->
        {
            try {
                return Strings.isBlank(BeanUtils.getProperty(value, s));
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            return true;
        });
    }
}
