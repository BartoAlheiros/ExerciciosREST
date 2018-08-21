package com.demo.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shop.exception.CustomerNotFoundException;
import com.demo.shop.model.Customer;
import com.demo.shop.model.Order;
import com.demo.shop.repository.CustomerRepository;
import com.demo.shop.repository.OrderRepository;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private OrderRepository orderRepository;

  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

  public List<Customer> findAll() {
    return customerRepository.findAll();
  }


  public Customer findOne(Long id) {
    Customer customer = customerRepository.getOne(id);
    if (customer == null) throw new CustomerNotFoundException(id);

    return customer;
  }


  public Customer update(Customer customerUpdated) {
    Customer customer = customerRepository.getOne(customerUpdated.getId());

    if (customer == null) {
      throw new CustomerNotFoundException(customerUpdated.getId());
    }else {
      customer.setName(customerUpdated.getName());
    }

    return customerRepository.save(customer);
  }

  public void delete(Long id) {
    Customer customer = customerRepository.getOne(id);
    if (customer == null) {
      throw new CustomerNotFoundException(id);
    }else {
      customerRepository.delete(customer);		
    }

  }

  public Customer saveOrderByCustomerID(Long id, Order order) {
    Customer customer = customerRepository.getOne(id);
    if (customer == null) {
      throw new CustomerNotFoundException(id);
    }else {
      order.setCustomer(customer);
      orderRepository.save(order);
    }
    return customer;
  }

  public List<Order> getOrdersByCustomerID(Long id) {
    Customer customer = customerRepository.getOne(id);
    List<Order> orders;
    if (customer == null) {
      throw new CustomerNotFoundException(id);
    }else {
      orders = customer.getOrders();
    }
    return orders;
  }

  public void deleteOrdersByCustomerID(Long id) {
    Customer customer = customerRepository.getOne(id);
    List<Order> orders;
    if (customer == null) {
      throw new CustomerNotFoundException(id);
    }else {
      orders = customer.getOrders();
      orderRepository.deleteInBatch(orders);
    }

  }
}
