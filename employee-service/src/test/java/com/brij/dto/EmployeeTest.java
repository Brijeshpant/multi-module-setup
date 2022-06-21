package com.brij.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldVerifyBlankEmployeeCodeIsInvalid() {
        Employee employee =
                getEmployeeRequestDTO("brijesh pant", "brij", "pant", "",
                        "bp@gmail.com", "9123456789", "233", "verification agency");
        List<ConstraintViolation<Employee>> validate = new ArrayList<>(validator.validate(employee));
        assertEquals(1, validate.size());
        assertEquals("employee code can not be blank, if present",
                validate.get(0).getMessage());
    }

    @Test
    void shouldVerifyNullEmployeeCodeIsValid() {
        Employee employee = getEmployeeRequestDTO("brijesh pant", "brij", "pant", null,
                "bp@gmail.com", "9123456789", "233", "verification agency");
        List<ConstraintViolation<Employee>> validate = new ArrayList<>(validator.validate(employee));
        assertEquals(0, validate.size());
    }

    @Test
    void shouldVerifyNonBlankEmployeeCodeIsValid() {
        Employee employee = getEmployeeRequestDTO("brijesh pant", "brij", "pant", "empc1",
                "bp@gmail.com", "9123456789", "233", "verification agency");
        List<ConstraintViolation<Employee>> validate = new ArrayList<>(validator.validate(employee));
        assertEquals(0, validate.size());
    }

    @Test
    void shouldVerifyEmployeeForInvalidNameAttributes() {
        Employee employee = getEmployeeRequestDTO("", "", "", "empc1",
                "bp@gmail.com", "9123456789", "233", "verification agency");
        List<ConstraintViolation<Employee>> validate = new ArrayList<>(validator.validate(employee));
        assertEquals(1, validate.size());
        assertEquals("Either name or first name and last name are required", validate.get(0).getMessage());

    }

    @Test
    void shouldVerifyEmployeeForValidName() {
        Employee employee = getEmployeeRequestDTO("Brijesh", "", "", "empc1",
                "bp@gmail.com", "9123456789", "233", "verification agency");
        List<ConstraintViolation<Employee>> validate = new ArrayList<>(validator.validate(employee));
        assertEquals(0, validate.size());

    }

    @Test
    void shouldVerifyEmployeeForValidFirstnameAndLastName() {
        Employee employee = getEmployeeRequestDTO("", "brijesh", "pant", "empc1",
                "bp@gmail.com", "9123456789", "233", "verification agency");
        List<ConstraintViolation<Employee>> validate = new ArrayList<>(validator.validate(employee));
        assertEquals(0, validate.size());

    }

    @Test
    void shouldVerifyOneOfEmailOrPhoneRequired() {
        Employee employee = getEmployeeRequestDTO("", "brijesh", "pant", "empc1",
                "", "", "233", "verification agency");
        List<ConstraintViolation<Employee>> validate = new ArrayList<>(validator.validate(employee));
        assertEquals(1, validate.size());
        assertEquals("Either email or phone are required", validate.get(0).getMessage());

    }

    @Test
    void shouldVerifyEmailIsValidWithoutPhone() {
        Employee employee = getEmployeeRequestDTO("", "brijesh", "pant", "empc1",
                "bp@gmail.com", "", "233", "verification agency");
        List<ConstraintViolation<Employee>> validate = new ArrayList<>(validator.validate(employee));
        assertEquals(0, validate.size());

    }

    @Test
    void shouldVerifyPhoneIsValidWithoutEmail() {
        Employee employee = getEmployeeRequestDTO("", "brijesh", "pant", "empc1",
                "", "9123456789", "233", "verification agency");
        List<ConstraintViolation<Employee>> validate = new ArrayList<>(validator.validate(employee));
        assertEquals(0, validate.size());

    }

    @Test
    void shouldVerifyInvalidVerificationId() {
        Employee employee = getEmployeeRequestDTO("brijesh", "", "", "empc1",
                "bp@gmail.com", "9123456789", "233", "");
        List<ConstraintViolation<Employee>> validate = new ArrayList<>(validator.validate(employee));
        assertEquals(1, validate.size());
        assertEquals("verifiedBy is required with verificationId",
                validate.get(0).getMessage());

    }

    @Test
    void shouldVerifyValidVerificationId() {
        Employee employee = getEmployeeRequestDTO("brijesh", "", "", "empc1",
                "bp@gmail.com", "9123456789", "233", "");
        List<ConstraintViolation<Employee>> validate = new ArrayList<>(validator.validate(employee));
        assertEquals(1, validate.size());
        assertEquals("verifiedBy is required with verificationId",
                validate.get(0).getMessage());

    }

    private Employee getEmployeeRequestDTO(String name, String firstName, String lastName, String employeeCode,
                                           String email, String phone, String verificationId, String verifiedBy) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmployeeCode(employeeCode);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setVerificationId(verificationId);
        employee.setVerifiedBy(verifiedBy);
        return employee;
    }


}