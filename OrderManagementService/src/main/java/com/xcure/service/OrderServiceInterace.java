package com.xcure.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.xcure.dto.OrderDto;
import com.xcure.entity.Order;

public interface OrderServiceInterace {
	

	Order findOrderById(UUID productId );
	
	List<Order> allOrders();
	
	OrderDto createOrder(OrderDto orderDto); 
	
	Void deleteOrder(UUID productId);
	
	OrderDto updateOrder(UUID productId, OrderDto orderDto);
	
	OrderDto patchOrder(UUID productId,OrderDto orderDto);
	
	Page<Order> paginationOrder(int page, int size);
	
	
}
