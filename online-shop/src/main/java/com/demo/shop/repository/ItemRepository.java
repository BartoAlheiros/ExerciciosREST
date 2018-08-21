package com.demo.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.shop.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
