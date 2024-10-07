package com.xcure.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Invoice {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID invoiceId;
	
	private String billingAddress;
	
	private BigDecimal totalAmount;
	
	private BigDecimal taxAmount;
	
	private BigDecimal discountAmount;
	
	private String status;
	
	private LocalDateTime dueAt;
	
	private LocalDateTime paidAt;

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UUID getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(UUID invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDueAt() {
		return dueAt;
	}

	public void setDueAt(LocalDateTime dueAt) {
		this.dueAt = dueAt;
	}

	public LocalDateTime getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(LocalDateTime paidAt) {
		this.paidAt = paidAt;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", billingAddress=" + billingAddress + ", totalAmount=" + totalAmount
				+ ", taxAmount=" + taxAmount + ", discountAmount=" + discountAmount + ", status=" + status + ", dueAt="
				+ dueAt + ", paidAt=" + paidAt + "]";
	}
	
	
	
}
