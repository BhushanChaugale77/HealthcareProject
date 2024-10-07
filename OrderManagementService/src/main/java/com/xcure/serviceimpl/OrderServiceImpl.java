package com.xcure.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xcure.dto.OrderDto;
import com.xcure.entity.Order;
import com.xcure.repository.OrderRepository;
import com.xcure.service.OrderServiceInterace;

@Service
public class OrderServiceImpl implements OrderServiceInterace  {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private OrderRepository repository;

	@Override
	public Order findOrderById(UUID productId) {
 		return repository.findById(productId).orElseThrow();
	}

	@Override
	public List<Order> allOrders() {
		return repository.findAll();
	}

	@Override
	public OrderDto createOrder(OrderDto orderDto) {
		Order order = mapper.map(orderDto, Order.class);
		repository.save(order);
		OrderDto dto = mapper.map(order, OrderDto.class);
		return dto;
	}

	@Override
	public Void deleteOrder(UUID productId) {
		repository.deleteById(productId);
		return null;
	}

	@Override
	public OrderDto updateOrder(UUID productId, OrderDto orderDto) {
		Order order = mapper.map(orderDto, Order.class);
		
		order.setOrderItemId(orderDto.getOrderItemId());
		order.setPrescriptionId(orderDto.getPrescriptionId());
		order.setProductId(orderDto.getProductId());
		order.setProductType(orderDto.getProductType());
		order.setQuantity(orderDto.getQuantity());
		order.setTotalPrice(orderDto.getTotalPrice());
		order.setUnitPrice(orderDto.getUnitPrice());
		
		repository.saveAndFlush(order);
		OrderDto dto = mapper.map(order, OrderDto.class);
		return dto;
	}

	@Override
	public OrderDto patchOrder(UUID productId, OrderDto orderDto) {
		Order order = mapper.map(orderDto, Order.class);
		
		order.setOrderItemId(orderDto.getOrderItemId());
 		order.setQuantity(orderDto.getQuantity());
		order.setTotalPrice(orderDto.getTotalPrice());
		order.setUnitPrice(orderDto.getUnitPrice());
		
		repository.flush();
		OrderDto dto = mapper.map(order, OrderDto.class);
		return dto;
	}

	@Override
	public Page<Order> paginationOrder(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
	
	
}
