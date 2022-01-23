package com.example.CustomerService.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * InputProduct
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-14T15:25:09.990+05:30[Asia/Calcutta]")
public class InputProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("productName")
	private String productName = null;

	@JsonProperty("productPrice")
	private BigDecimal productPrice = null;

	@JsonProperty("company")
	private String company = null;

	@JsonProperty("inventory")
	private Integer inventory = null;

	public InputProduct productId(Integer productId) {
		return this;
	}

	public InputProduct productName(String productName) {
		this.productName = productName;
		return this;
	}

	/**
	 * Get productName
	 * 
	 * @return productName
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public InputProduct productPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
		return this;
	}

	/**
	 * Get productPrice
	 * 
	 * @return productPrice
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	@Valid
	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public InputProduct company(String company) {
		this.company = company;
		return this;
	}

	/**
	 * Get company
	 * 
	 * @return company
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public InputProduct inventory(Integer inventory) {
		this.inventory = inventory;
		return this;
	}

	/**
	 * Get inventory
	 * 
	 * @return inventory
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InputProduct inputProduct = (InputProduct) o;
		return Objects.equals(this.productName, inputProduct.productName)
				&& Objects.equals(this.productPrice, inputProduct.productPrice)
				&& Objects.equals(this.company, inputProduct.company)
				&& Objects.equals(this.inventory, inputProduct.inventory);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productName, productPrice, company, inventory);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InputProduct {\n");

		sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
		sb.append("    productPrice: ").append(toIndentedString(productPrice)).append("\n");
		sb.append("    company: ").append(toIndentedString(company)).append("\n");
		sb.append("    inventory: ").append(toIndentedString(inventory)).append("\n");
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
