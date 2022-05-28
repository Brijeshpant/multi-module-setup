package com.brij.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EmployeeRequestDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-28T22:33:33.870+05:30[Asia/Kolkata]")

public class EmployeeRequestDTO   {
  @JsonProperty("id")
  private String id;
  @JsonProperty("salary")
  private String salary;

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("joiningDate")
  private OffsetDateTime joiningDate;

  /**
   * Employee type
   */
  public enum EmployeeTypeEnum {
    HR("HR"),
    
    ADMIN("ADMIN"),
    
    IT("IT");

    private String value;

    EmployeeTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EmployeeTypeEnum fromValue(String text) {
      for (EmployeeTypeEnum b : EmployeeTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("employeeType")
  private EmployeeTypeEnum employeeType;

  @JsonProperty("active")
  private Boolean active = false;

  public EmployeeRequestDTO id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(example = "EMP-1", required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EmployeeRequestDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the employee
   * @return name
  */
  @ApiModelProperty(example = "bp", required = true, value = "name of the employee")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EmployeeRequestDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(example = "bp@gmail.com", required = true, value = "")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EmployeeRequestDTO joiningDate(OffsetDateTime joiningDate) {
    this.joiningDate = joiningDate;
    return this;
  }

  /**
   * Get joiningDate
   * @return joiningDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(OffsetDateTime joiningDate) {
    this.joiningDate = joiningDate;
  }

  public EmployeeRequestDTO employeeType(EmployeeTypeEnum employeeType) {
    this.employeeType = employeeType;
    return this;
  }

  /**
   * Employee type
   * @return employeeType
  */
  @ApiModelProperty(example = "IT", required = true, value = "Employee type")
  @NotNull


  public EmployeeTypeEnum getEmployeeType() {
    return employeeType;
  }

  public void setEmployeeType(EmployeeTypeEnum employeeType) {
    this.employeeType = employeeType;
  }

  public EmployeeRequestDTO active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeRequestDTO employeeRequestDTO = (EmployeeRequestDTO) o;
    return Objects.equals(this.id, employeeRequestDTO.id) &&
        Objects.equals(this.name, employeeRequestDTO.name) &&
        Objects.equals(this.email, employeeRequestDTO.email) &&
        Objects.equals(this.joiningDate, employeeRequestDTO.joiningDate) &&
        Objects.equals(this.employeeType, employeeRequestDTO.employeeType) &&
        Objects.equals(this.active, employeeRequestDTO.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, joiningDate, employeeType, active);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeRequestDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    joiningDate: ").append(toIndentedString(joiningDate)).append("\n");
    sb.append("    employeeType: ").append(toIndentedString(employeeType)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

