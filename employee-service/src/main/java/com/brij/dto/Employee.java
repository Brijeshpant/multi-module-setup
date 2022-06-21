package com.brij.dto;

import com.brij.dto.validator.ConditionalValid;
import com.brij.dto.validator.NameValid;
import com.brij.dto.validator.NullOrNotBlank;
import lombok.Data;


@Data
//@NameValid(message = ="employee code can not be blank, if present")
@ConditionalValid(field = "name", dependentFields = {"firstName", "lastName"}, message = "Either name or first name and last name are required")
@ConditionalValid(field = "email", dependentFields = {"phone"}, message = "Either email or phone are required")
@ConditionalValid(field = "verificationId", dependentFields = {"verifiedBy"},mExclusive = false, message = "verifiedBy is required with verificationId")
public class Employee {
    //can be null, but if present should not be blank
    @NullOrNotBlank(message = "employee code can not be blank, if present")
    private String employeeCode;

    // either name or firstname and last name are required
    private String name;
    private String firstName;
    private String lastName;

    //either email or  phone is required
    private String email;
    private String phone;

    //if verificationId not blanked verifiedBy can not be blank
    private String verificationId;
    private String verifiedBy;
}

