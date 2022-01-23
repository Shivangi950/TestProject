package com.example.CustomerService.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CustomerAmount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-14T00:13:12.191+05:30[Asia/Calcutta]")
public class CustomerAmount  implements Serializable  {
  private static final long serialVersionUID = 1L;

  @JsonProperty("customerId")
  private Integer customerId = null;

  @JsonProperty("value")
  private BigDecimal value = null;

  public CustomerAmount customerId(Integer customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  **/
  @ApiModelProperty(value = "")
  
    public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public CustomerAmount value(BigDecimal value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerAmount customerAmount = (CustomerAmount) o;
    return Objects.equals(this.customerId, customerAmount.customerId) &&
        Objects.equals(this.value, customerAmount.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerAmount {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
