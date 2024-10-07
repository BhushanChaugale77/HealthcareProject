package com.xcure.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID orderItemId;
	
	private UUID productId;
	
	private String productType;
	
	private Integer quantity;
	
	private BigDecimal unitPrice;
	
	private BigDecimal totalPrice;
	
	private UUID prescriptionId;

	public Order() {
		super();
 	}

	public UUID getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(UUID orderItemId) {
		this.orderItemId = orderItemId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public UUID getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(UUID prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	@Override
	public String toString() {
		return "Order [orderItemId=" + orderItemId + ", productId=" + productId + ", productType=" + productType
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice
				+ ", prescriptionId=" + prescriptionId + "]";
	}	
	
}
