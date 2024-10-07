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

import com.xcure.dto.OrderDto;
import com.xcure.entity.Order;
import com.xcure.service.OrderServiceInterace;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private OrderServiceInterace serviceInterace;
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable UUID productId){
		return new ResponseEntity<Order>(serviceInterace.findOrderById(productId),HttpStatus.FOUND);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Order>> allOrders(){
		return new ResponseEntity<List<Order>>(serviceInterace.allOrders(),HttpStatus.FOUND);
	}
	@PostMapping
	public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
			return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<OrderDto>(serviceInterace.createOrder(orderDto),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrderById(@PathVariable UUID productId){
		return new ResponseEntity<Void>(serviceInterace.deleteOrder(productId),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrderDto> updateOrderDtoById(@Valid @PathVariable UUID productId,@RequestBody OrderDto orderDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
		}
		return new ResponseEntity<OrderDto>(serviceInterace.updateOrder(productId, orderDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<OrderDto> patchOrderById(@Valid @PathVariable UUID productId, @RequestBody OrderDto orderDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
		}
		return new ResponseEntity<OrderDto>(serviceInterace.patchOrder(productId, orderDto),HttpStatus.UPGRADE_REQUIRED);		
	}
	
	@GetMapping
	public ResponseEntity<Page<Order>> paginationOrder(@RequestParam int page, @RequestParam int size){
		return new ResponseEntity<Page<Order>>(serviceInterace.paginationOrder(page, size),HttpStatus.OK);
	}
	
}

