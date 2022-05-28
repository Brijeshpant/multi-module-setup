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
 * EmployeeResponseDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-28T22:33:33.870+05:30[Asia/Kolkata]")

public class EmployeeResponseDTO   {
  @JsonProperty("id")
  private String id;

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

  public EmployeeResponseDTO id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(example = "EMP-1", value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EmployeeResponseDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the employee
   * @return name
  */
  @ApiModelProperty(example = "bp", value = "name of the employee")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EmployeeResponseDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(example = "bp@gmail.com", value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EmployeeResponseDTO joiningDate(OffsetDateTime joiningDate) {
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

  public EmployeeResponseDTO employeeType(EmployeeTypeEnum employeeType) {
    this.employeeType = employeeType;
    return this;
  }

  /**
   * Employee type
   * @return employeeType
  */
  @ApiModelProperty(example = "IT", value = "Employee type")


  public EmployeeTypeEnum getEmployeeType() {
    return employeeType;
  }

  public void setEmployeeType(EmployeeTypeEnum employeeType) {
    this.employeeType = employeeType;
  }

  public EmployeeResponseDTO active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
  */
  @ApiModelProperty(value = "")


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
    EmployeeResponseDTO employeeResponseDTO = (EmployeeResponseDTO) o;
    return Objects.equals(this.id, employeeResponseDTO.id) &&
        Objects.equals(this.name, employeeResponseDTO.name) &&
        Objects.equals(this.email, employeeResponseDTO.email) &&
        Objects.equals(this.joiningDate, employeeResponseDTO.joiningDate) &&
        Objects.equals(this.employeeType, employeeResponseDTO.employeeType) &&
        Objects.equals(this.active, employeeResponseDTO.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, joiningDate, employeeType, active);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeResponseDTO {\n");
    
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

