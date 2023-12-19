package com.program.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.program.orderservice.dto.OrderRequest;
import com.program.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/orders")


public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public String placeOrder(@RequestBody OrderRequest orderRequest)
	{
		
		orderService.placeOrder(orderRequest);
		return "order placed successfull";
	}
}
