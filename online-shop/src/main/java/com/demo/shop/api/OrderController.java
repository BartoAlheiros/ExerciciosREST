package com.demo.shop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shop.model.Order;
import com.demo.shop.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;  

	@GetMapping
	public List<Order> listAll(Order order) {
		Example<Order> example = Example.of(order);
		return orderRepository.findAll(example);	  
	}

	@PostMapping
	public Order save(@RequestBody Order order) {
		return orderRepository.save(order);
	}

	@GetMapping(path = "/{id}")
	public Order get(@PathVariable("id") Long id) {
		return orderRepository.findOne(id);
	}

	@PutMapping(path = "/{id}")
	public Order update(@RequestBody Order order, @PathVariable("id") Long id) {
		Order orderInstance = orderRepository.findOne(id);
		try {
			orderInstance.setId(id);
		} catch (NullPointerException e){
			System.out.println(e.getMessage());
		}
		
		return orderRepository.save(order);
	}
}
