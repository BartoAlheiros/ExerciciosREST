package com.demo.shop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shop.model.Product;
import com.demo.shop.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping
	public Product save(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@GetMapping
	public List<Product> listAll(Product product) {
		Example<Product> example = Example.of(product);
		return productRepository.findAll(example);
	}
	
	@GetMapping(path="/filter")
	public List<Product> filterBy(@RequestParam String name) {
		return productRepository.findByNameLike(name);
	}

	@GetMapping(path = "/{id}")
	public Product get(@PathVariable("id") Long id) {
		return productRepository.findOne(id);
	}
}
