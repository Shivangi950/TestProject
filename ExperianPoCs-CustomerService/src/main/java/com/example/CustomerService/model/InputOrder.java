package com.example.CustomerService.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * InputOrder
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-14T00:13:12.191+05:30[Asia/Calcutta]")
public class InputOrder  implements Serializable  {
  private static final long serialVersionUID = 1L;

  @JsonProperty("customerId")
  private Integer customerId = null;

  @JsonProperty("orderProducts")
  @Valid
  private List<InputOrderProduct> orderProducts = null;

  public InputOrder customerId(Integer customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public InputOrder orderProducts(List<InputOrderProduct> orderProducts) {
    this.orderProducts = orderProducts;
    return this;
  }

  public InputOrder addOrderProductsItem(InputOrderProduct orderProductsItem) {
    if (this.orderProducts == null) {
      this.orderProducts = new ArrayList<>();
    }
    this.orderProducts.add(orderProductsItem);
    return this;
  }

  /**
   * Get orderProducts
   * @return orderProducts
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<InputOrderProduct> getOrderProducts() {
    return orderProducts;
  }

  public void setOrderProducts(List<InputOrderProduct> orderProducts) {
    this.orderProducts = orderProducts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputOrder inputOrder = (InputOrder) o;
    return Objects.equals(this.customerId, inputOrder.customerId) &&
        Objects.equals(this.orderProducts, inputOrder.orderProducts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, orderProducts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputOrder {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    orderProducts: ").append(toIndentedString(orderProducts)).append("\n");
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
