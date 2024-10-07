package com.xcure.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xcure.dto.InvoiceDto;
import com.xcure.entity.Invoice;
import com.xcure.repository.InvoiceRepository;
import com.xcure.service.InvoiceServiceInterface;

@Service
public class InvoiceServiceImpl implements InvoiceServiceInterface {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private InvoiceRepository repository;
	
	@Override
	public Invoice findInvoiceById(UUID invoiceId) {
 		return repository.findById(invoiceId).orElseThrow();
	}
	@Override
	public List<Invoice> allInvoice() {
 		return repository.findAll();
	}
	@Override
	public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
		Invoice invoice = mapper.map(invoiceDto, Invoice.class);
		repository.save(invoice);
		InvoiceDto dto = mapper.map(invoice, InvoiceDto.class);
		return dto;
	}
	@Override
	public void deleteInvoiceById(UUID invoiceId) {
		repository.deleteById(invoiceId);
	}
	
	@Override
	public InvoiceDto updateInvoiceById(UUID invoiceId, InvoiceDto invoiceDto) {
		Invoice invoice = mapper.map(invoiceDto, Invoice.class);
		
		invoice.setBillingAddress(invoiceDto.getBillingAddress());
		invoice.setDiscountAmount(invoiceDto.getDiscountAmount());
		invoice.setDueAt(invoiceDto.getDueAt());
		invoice.setInvoiceId(invoiceDto.getInvoiceId());
		invoice.setPaidAt(invoiceDto.getPaidAt());
		invoice.setStatus(invoiceDto.getStatus());
		invoice.setTaxAmount(invoiceDto.getTaxAmount());
		invoice.setTotalAmount(invoiceDto.getTotalAmount());
		
		repository.saveAndFlush(invoice);
		InvoiceDto dto = mapper.map(invoice, InvoiceDto.class);
		return dto;
	}
	
	@Override
	public InvoiceDto patchInvoiceById(UUID invoiceId, InvoiceDto invoiceDto) {
		Invoice invoice = mapper.map(invoiceDto, Invoice.class);

		invoice.setBillingAddress(invoiceDto.getBillingAddress());
		invoice.setDiscountAmount(invoiceDto.getDiscountAmount());
		invoice.setStatus(invoiceDto.getStatus());
		invoice.setTaxAmount(invoiceDto.getTaxAmount());
		invoice.setTotalAmount(invoiceDto.getTotalAmount());
		
		repository.flush();
		InvoiceDto dto = mapper.map(invoice, InvoiceDto.class);
		return dto;
	}
	
	@Override
	public Page<Invoice> paginationInvoice(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
	
	
	
}
