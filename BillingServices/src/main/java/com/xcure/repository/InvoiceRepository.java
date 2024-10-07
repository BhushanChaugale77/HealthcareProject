package com.xcure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcure.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {

}
