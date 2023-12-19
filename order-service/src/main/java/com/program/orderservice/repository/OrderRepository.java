package com.program.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.program.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
