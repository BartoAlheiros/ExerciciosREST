package com.demo.shop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shop.model.Customer;
import com.demo.shop.model.Order;
import com.demo.shop.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
 
  @Autowired
  private CustomerService customerService;

  @GetMapping(path = "/listAll")
  public List<Customer> listAll() {
    return customerService.findAll();	  
  }

  @PostMapping(path = "/add")
  public Customer save(@RequestBody Customer customer) {
    return customerService.save(customer);
  }

  @GetMapping(path = "/get/{id}")
  public Customer get(@PathVariable("id") Long id) {
    return customerService.findOne(id);
  }
  
  @PostMapping(path = "/update")
  public Customer update(@RequestBody Customer customer) {
    return customerService.update(customer);
  }
  
  @DeleteMapping(path = "/delete/{id}")
  public void delete(@PathVariable("id") Long id) {
    customerService.delete(id);
  }
  
  @GetMapping(path = "/{id}/orders")
  public List<Order> getOrdersByCustomerID(@PathVariable("id") Long id) {
    return customerService.getOrdersByCustomerID(id);
  }
  
  @PostMapping(path = "/{id}/addOrder")
  public Customer addOrderByCustomerID(@PathVariable("id") Long id, @RequestBody Order order) {
    return customerService.saveOrderByCustomerID(id, order);
  }
  
  @DeleteMapping(path = "/{id}/deleteOrders")
  public void deleteOrdersByCustomerID(@PathVariable("id") Long id) {
    customerService.deleteOrdersByCustomerID(id);
  }
}
