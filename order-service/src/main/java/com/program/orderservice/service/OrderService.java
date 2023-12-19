package com.program.orderservice.service;

import java.util.UUID;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.program.orderservice.dto.OrderLineItemsDto;
import com.program.orderservice.dto.OrderRequest;
import com.program.orderservice.model.Order;
import com.program.orderservice.model.OrderLineItems;
import com.program.orderservice.repository.OrderRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;
	
	public void placeOrder(OrderRequest orderRequest) {
	Order order=new Order();
	
	order.setOrderNumber(UUID.randomUUID().toString());
	List<OrderLineItems> orderLineitems=orderRequest.getOrderLineItemsDtoList()
			.stream()
			.map(this::mapToDto)
			.toList();
	order.setOrderLineItemsList(orderLineitems);
	
	orderRepository.save(order);
	}
	 private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
	        OrderLineItems orderLineItems = new OrderLineItems();
	        orderLineItems.setPrice(orderLineItemsDto.getPrice());
	        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
	        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
	        return orderLineItems;
	    }
}
