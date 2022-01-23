package com.example.orderservice.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.persistence.*;

/**
 * Product
 */
@Validated
@Entity
@Table(name = "Product")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-14T00:13:12.191+05:30[Asia/Calcutta]")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("productId")
	private Integer productId = null;

	@JsonProperty("productName")
	private String productName = null;

	@JsonProperty("productPrice")
	private BigDecimal productPrice = null;

	@JsonProperty("company")
	private String company = null;

	@JsonProperty("inventory")
	private Integer inventory = null;

	public Product productId(Integer productId) {
		this.productId = productId;
		return this;
	}

	/**
	 * Get productId
	 * 
	 * @return productId
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Product productName(String productName) {
		this.productName = productName;
		return this;
	}

	/**
	 * Get productName
	 * 
	 * @return productName
	 **/
	@ApiModelProperty(example = "Widget Adapter", required = true, value = "")
	@NotNull

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Product productPrice(BigDecimal productPrice) {
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

	public Product company(String company) {
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

	public Product inventory(Integer inventory) {
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
		Product product = (Product) o;
		return Objects.equals(this.productId, product.productId)
				&& Objects.equals(this.productName, product.productName)
				&& Objects.equals(this.productPrice, product.productPrice)
				&& Objects.equals(this.company, product.company) && Objects.equals(this.inventory, product.inventory);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, productName, productPrice, company, inventory);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Product {\n");

		sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
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
