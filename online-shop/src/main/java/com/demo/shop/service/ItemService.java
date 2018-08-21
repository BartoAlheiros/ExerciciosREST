package com.demo.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shop.model.Item;
import com.demo.shop.repository.ItemRepository;

@Service
public class ItemService {

  @Autowired
  private ItemRepository itemRepository;
  
  public Item save(Item item) {
    return itemRepository.save(item);
  }

  public List<Item> findAll() {
    return itemRepository.findAll();
  }
}
