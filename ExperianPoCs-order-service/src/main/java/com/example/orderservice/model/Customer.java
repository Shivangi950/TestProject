package com.example.orderservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Customer
 */
@Validated
@Entity
@Table(name = "Customer")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-11T18:46:35.701+05:30[Asia/Calcutta]")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("customerId")
	private Integer customerId = null;

	@JsonProperty("customerName")
	private String customerName = null;

	@JsonProperty("modeOfPayment")
	private String modeOfPayment = null;

	@JsonProperty("debitAvailable")
	private BigDecimal debitAvailable = null;

	@JsonProperty("customerAddress")
	private String customerAddress = null;

	/*
	 * @OneToOne(mappedBy = "customer") private Order order;
	 * 
	 * public Order getOrder() { return order; }
	 * 
	 * public void setOrder(Order order) { this.order = order; }
	 */

	/**
	 * Gets or Sets status
	 */
	public enum StatusEnum {
		ACTIVE("active"),

		INACTIVE("inactive"),

		BLOCKED("blocked");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("status")
	private StatusEnum status = null;

	public Customer customerId(Integer customerId) {
		this.customerId = customerId;
		return this;
	}

	/**
	 * Get customerId
	 * 
	 * @return customerId
	 **/
	@ApiModelProperty(value = "")

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Customer customerName(String customerName) {
		this.customerName = customerName;
		return this;
	}

	/**
	 * Get customerName
	 * 
	 * @return customerName
	 **/
	@ApiModelProperty(value = "")

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Customer modeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
		return this;
	}

	/**
	 * Get modeOfPayment
	 * 
	 * @return modeOfPayment
	 **/
	@ApiModelProperty(value = "")

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Customer debitAvailable(BigDecimal debitAvailable) {
		this.debitAvailable = debitAvailable;
		return this;
	}

	/**
	 * Get debitAvailable
	 * 
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

	public Customer customerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
		return this;
	}

	/**
	 * Get customerAddress
	 * 
	 * @return customerAddress
	 **/
	@ApiModelProperty(value = "")

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Customer status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@ApiModelProperty(value = "")

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Customer customer = (Customer) o;
		return Objects.equals(this.customerId, customer.customerId)
				&& Objects.equals(this.customerName, customer.customerName)
				&& Objects.equals(this.modeOfPayment, customer.modeOfPayment)
				&& Objects.equals(this.debitAvailable, customer.debitAvailable)
				&& Objects.equals(this.customerAddress, customer.customerAddress)
				&& Objects.equals(this.status, customer.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, customerName, modeOfPayment, debitAvailable, customerAddress, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Customer {\n");

		sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
		sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
		sb.append("    modeOfPayment: ").append(toIndentedString(modeOfPayment)).append("\n");
		sb.append("    debitAvailable: ").append(toIndentedString(debitAvailable)).append("\n");
		sb.append("    customerAddress: ").append(toIndentedString(customerAddress)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
