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

import com.demo.shop.model.Item;
import com.demo.shop.model.Order;
import com.demo.shop.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;  

  @GetMapping("/listAll")
  public List<Order> listAll() {
    return orderService.findAll();	  
  }

  @PostMapping("/add")
  public Order save(@RequestBody Order order) {
    return orderService.save(order);
  }

  @GetMapping(path = "/get/{id}")
  public Order get(@PathVariable("id") Long id) {
    return orderService.findOne(id);
  }

  /* 'order' is the order passed by the user at RequestBody */
  /* is the order with the id passed at RequestBody(if it exists) */
  @PostMapping(path = "/update")
  public Order update(@RequestBody Order order) {
    return orderService.update(order);
  }

  @PostMapping(path = "/addItem/{id}")
  public Item addItem(@RequestBody Item item, @PathVariable("id") Long id) {
    return orderService.addItem(item, id); 
  }
  
  @DeleteMapping(path = "/delete/{id}")
  public void delete(@PathVariable("id") Long id) {
    orderService.delete(id);
  }
}
