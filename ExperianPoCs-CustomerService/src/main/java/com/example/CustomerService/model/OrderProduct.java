package com.example.CustomerService.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * OrderProduct
 */
@Entity
@Table(name = "OrderProduct")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-14T00:13:12.191+05:30[Asia/Calcutta]")
public class OrderProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("orderProductId")
	private Integer orderProductId = null;

	public Integer getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(Integer orderProductId) {
		this.orderProductId = orderProductId;
	}
	
	@OneToOne
	//@JoinColumn(name="pId", referencedColumnName = "productId")
	private Product product = null;

	@JsonProperty("quantity")
	private Integer quantity = null;

	@JsonProperty("date")
	private LocalDate date = null;

	public OrderProduct product(Product product) {
		this.product = product;
		return this;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	//@JoinColumn(name = "orderId", nullable = false, referencedColumnName = "orderId")
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * Get product
	 * 
	 * @return product
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderProduct quantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * Get quantity
	 * 
	 * @return quantity
	 **/
	@ApiModelProperty(value = "")

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OrderProduct date(LocalDate date) {
		this.date = date;
		return this;
	}

	/**
	 * Start date
	 * 
	 * @return date
	 **/
	@ApiModelProperty(example = "Sun Jan 01 05:30:00 IST 2017", value = "Start date")

	@Valid
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		OrderProduct orderProduct = (OrderProduct) o;
		return Objects.equals(this.product, orderProduct.product)
				&& Objects.equals(this.quantity, orderProduct.quantity) && Objects.equals(this.date, orderProduct.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, quantity, date);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class OrderProduct {\n");

		sb.append("    product: ").append(toIndentedString(product)).append("\n");
		sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
		sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
