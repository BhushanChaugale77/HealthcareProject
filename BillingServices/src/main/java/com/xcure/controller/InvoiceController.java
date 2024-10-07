package com.xcure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xcure.dto.InvoiceDto;
import com.xcure.entity.Invoice;
import com.xcure.service.InvoiceServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private InvoiceServiceInterface serviceInterface;
	
	@GetMapping("/{id}")
	public ResponseEntity<Invoice> findInvoiceById(@PathVariable UUID invoiceId){
		return new ResponseEntity<Invoice>(serviceInterface.findInvoiceById(invoiceId),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Invoice>> allInvoice(){
		return new ResponseEntity<List<Invoice>>(serviceInterface.allInvoice(),HttpStatus.FOUND);
	}
	@PostMapping
	public ResponseEntity<InvoiceDto> createInvoice(@Valid @RequestBody InvoiceDto invoiceDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<InvoiceDto>(serviceInterface.createInvoice(invoiceDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInvoiceById(@PathVariable UUID invoiceId){
		serviceInterface.deleteInvoiceById(invoiceId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<InvoiceDto> updateInvoiceById(@Valid @PathVariable UUID invoiceId,@RequestBody InvoiceDto invoiceDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<InvoiceDto>(serviceInterface.updateInvoiceById(invoiceId, invoiceDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<InvoiceDto> patchInvoiceById(@Valid @PathVariable UUID invoiceId, @RequestBody InvoiceDto invoiceDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<InvoiceDto>(serviceInterface.patchInvoiceById(invoiceId, invoiceDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@GetMapping
	public ResponseEntity<Page<Invoice>> paginationInvoice(@RequestParam int page, @RequestParam int size){
		return new ResponseEntity<Page<Invoice>>(serviceInterface.paginationInvoice(page, size),HttpStatus.OK);
	}
}
