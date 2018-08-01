package com.demo.shop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shop.model.Customer;
import com.demo.shop.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public List<Customer> listAll(Customer customer) {
		Example<Customer> example = Example.of(customer);
		return customerRepository.findAll(example);	  
	}

	@PostMapping
	public Customer save(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	@GetMapping(path = "/{id}")
	public Customer get(@PathVariable("id") Long id) {
		return customerRepository.findOne(id);
	}
	
	
}
