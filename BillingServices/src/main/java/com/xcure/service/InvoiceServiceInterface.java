package com.xcure.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.xcure.dto.InvoiceDto;
import com.xcure.entity.Invoice;

public interface InvoiceServiceInterface {

	
	Invoice findInvoiceById(UUID invoiceId);
	
	List<Invoice> allInvoice();
	
	InvoiceDto createInvoice(InvoiceDto invoiceDto);
	
	void deleteInvoiceById(UUID invoiceId);
	
	InvoiceDto updateInvoiceById(UUID invoiceId, InvoiceDto invoiceDto);
	
	InvoiceDto patchInvoiceById(UUID invoiceId, InvoiceDto invoiceDto);
	
	Page<Invoice> paginationInvoice(int page, int size);
	
}
