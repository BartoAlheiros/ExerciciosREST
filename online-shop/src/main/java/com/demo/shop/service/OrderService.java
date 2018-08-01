package com.demo.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shop.model.Order;
import com.demo.shop.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findOne(Long id) {
		return orderRepository.getOne(id);
	}

	public Order update(Order order) {
		return orderRepository.save(order);
	}

	public void delete(Order order) {
		orderRepository.delete(order);
	}

	public void delete(List<Order> orders) {
		orderRepository.deleteInBatch(orders);
	}

}
