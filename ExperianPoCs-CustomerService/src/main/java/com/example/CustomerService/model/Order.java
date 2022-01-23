package com.example.CustomerService.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Order
 */
@Entity
@Table(name = "OrderTable")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-14T00:13:12.191+05:30[Asia/Calcutta]")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("orderId")
	private Integer orderId = null;

	/* This will create a column cId in OrderTable and stores customerId from customer table which is pkey of Customer*/
	@OneToOne
	//@JoinColumn(name="cId", referencedColumnName = "customerId")
	private Customer customer = null;

	@JsonIgnore
	@JsonProperty("orderProducts")
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderProduct> orderProducts = null;

	@JsonProperty("orderValue")
	private BigDecimal orderValue = null;

	/**
	 * Gets or Sets ordStatus
	 */
	public enum OrdStatusEnum {
		SUCCESS("success"),

		FAILED("failed"),

		PENDING("pending");

		private String value;

		OrdStatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static OrdStatusEnum fromValue(String text) {
			for (OrdStatusEnum b : OrdStatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("ordStatus")
	private OrdStatusEnum ordStatus = null;

	public Order orderId(Integer orderId) {
		this.orderId = orderId;
		return this;
	}

	/**
	 * Get orderId
	 * 
	 * @return orderId
	 **/
	@ApiModelProperty(value = "")

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Order customer(Customer customer) {
		this.customer = customer;
		return this;
	}

	/**
	 * Get customer
	 * 
	 * @return customer
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order orderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
		return this;
	}

	public Order addOrderProductsItem(OrderProduct orderProductsItem) {
		if (this.orderProducts == null) {
			this.orderProducts = new ArrayList<>();
		}
		this.orderProducts.add(orderProductsItem);
		return this;
	}

	/**
	 * Get orderProducts
	 * 
	 * @return orderProducts
	 **/
	@ApiModelProperty(value = "")
	@Valid
	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public Order orderValue(BigDecimal orderValue) {
		this.orderValue = orderValue;
		return this;
	}

	/**
	 * Get orderValue
	 * 
	 * @return orderValue
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public BigDecimal getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(BigDecimal orderValue) {
		this.orderValue = orderValue;
	}

	public Order ordStatus(OrdStatusEnum ordStatus) {
		this.ordStatus = ordStatus;
		return this;
	}

	/**
	 * Get ordStatus
	 * 
	 * @return ordStatus
	 **/
	@ApiModelProperty(value = "")

	public OrdStatusEnum getOrdStatus() {
		return ordStatus;
	}

	public void setOrdStatus(OrdStatusEnum ordStatus) {
		this.ordStatus = ordStatus;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Order order = (Order) o;
		return Objects.equals(this.orderId, order.orderId) && Objects.equals(this.customer, order.customer)
				&& Objects.equals(this.orderProducts, order.orderProducts)
				&& Objects.equals(this.orderValue, order.orderValue) && Objects.equals(this.ordStatus, order.ordStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, customer, orderProducts, orderValue, ordStatus);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Order {\n");

		sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
		sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
		sb.append("    orderProducts: ").append(toIndentedString(orderProducts)).append("\n");
		sb.append("    orderValue: ").append(toIndentedString(orderValue)).append("\n");
		sb.append("    ordStatus: ").append(toIndentedString(ordStatus)).append("\n");
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
