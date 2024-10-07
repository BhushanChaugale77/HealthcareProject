package com.xcure.dto;

import java.math.BigDecimal;
import java.util.UUID;

import io.micrometer.common.lang.NonNull;

public class OrderDto {

	@NonNull
	private UUID orderItemId;
	@NonNull
	private UUID productId;
	@NonNull
	private String productType;
	@NonNull
	private Integer quantity;
	@NonNull
	private BigDecimal unitPrice;
	@NonNull
	private BigDecimal totalPrice;
	@NonNull
	private UUID prescriptionId;

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
		return "OrderDto [orderItemId=" + orderItemId + ", productId=" + productId + ", productType=" + productType
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice
				+ ", prescriptionId=" + prescriptionId + "]";
	}
	
	
	
	
}
