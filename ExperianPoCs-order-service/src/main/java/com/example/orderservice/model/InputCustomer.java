package com.example.orderservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * InputCustomer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-14T00:13:12.191+05:30[Asia/Calcutta]")
public class InputCustomer  implements Serializable  {
  private static final long serialVersionUID = 1L;

  @JsonProperty("customerName")
  private String customerName = null;

  @JsonProperty("modeOfPayment")
  private String modeOfPayment = null;

  @JsonProperty("debitAvailable")
  private BigDecimal debitAvailable = null;

  @JsonProperty("customerAddress")
  private String customerAddress = null;

  public InputCustomer customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  /**
   * Get customerName
   * @return customerName
  **/
  @ApiModelProperty(value = "")
  
    public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public InputCustomer modeOfPayment(String modeOfPayment) {
    this.modeOfPayment = modeOfPayment;
    return this;
  }

  /**
   * Get modeOfPayment
   * @return modeOfPayment
  **/
  @ApiModelProperty(value = "")
  
    public String getModeOfPayment() {
    return modeOfPayment;
  }

  public void setModeOfPayment(String modeOfPayment) {
    this.modeOfPayment = modeOfPayment;
  }

  public InputCustomer debitAvailable(BigDecimal debitAvailable) {
    this.debitAvailable = debitAvailable;
    return this;
  }

  /**
   * Get debitAvailable
   * @return debitAvailable
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getDebitAvailable() {
    return debitAvailable;
  }

  public void setDebitAvailable(BigDecimal debitAvailable) {
    this.debitAvailable = debitAvailable;
  }

  public InputCustomer customerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
    return this;
  }

  /**
   * Get customerAddress
   * @return customerAddress
  **/
  @ApiModelProperty(value = "")
  
    public String getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputCustomer inputCustomer = (InputCustomer) o;
    return Objects.equals(this.customerName, inputCustomer.customerName) &&
        Objects.equals(this.modeOfPayment, inputCustomer.modeOfPayment) &&
        Objects.equals(this.debitAvailable, inputCustomer.debitAvailable) &&
        Objects.equals(this.customerAddress, inputCustomer.customerAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerName, modeOfPayment, debitAvailable, customerAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputCustomer {\n");
    
    sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
    sb.append("    modeOfPayment: ").append(toIndentedString(modeOfPayment)).append("\n");
    sb.append("    debitAvailable: ").append(toIndentedString(debitAvailable)).append("\n");
    sb.append("    customerAddress: ").append(toIndentedString(customerAddress)).append("\n");
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
