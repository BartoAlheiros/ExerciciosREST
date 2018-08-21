package com.demo.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shop.exception.OrderNotFoundException;
import com.demo.shop.model.Item;
import com.demo.shop.model.Order;
import com.demo.shop.repository.ItemRepository;
import com.demo.shop.repository.OrderRepository;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private ItemRepository itemRepository;

  public Order save(Order order) {
    return orderRepository.save(order);
  }

  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  public Order findOne(Long id) {
    return orderRepository.getOne(id);
  }

  public Order update(Order orderUpdated) {

    Order order = orderRepository.getOne(orderUpdated.getId());

    if (order == null) {

      throw new OrderNotFoundException(orderUpdated.getId());

    }else {

      order.setReason(orderUpdated.getReason());
      order.setService(orderUpdated.getService());
      order.setId(orderUpdated.getId());
    }

    return orderRepository.save(order);
  }

  public void delete(Long id) {   

    for (Order o: orderRepository.findAll()) {
      if(o.getId().equals(id)) {
        orderRepository.delete(o);
      }
    }
    
  }

  public void delete(List<Order> orders) {
    orderRepository.deleteInBatch(orders);
  }

  public Item addItem(Item item, Long id) {
    
    Item itemR = null;

    Order order2 = orderRepository.getOne(id);
    
    if ( order2 == null ) {
      
      throw new OrderNotFoundException(id);
      
    }else {
      
      order2.getItems().add(item);
      itemR = itemRepository.save(item);
      orderRepository.save(order2);
      
    }
    
    return itemR;
    
  }
}
