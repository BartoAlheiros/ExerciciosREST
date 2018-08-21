package com.demo.shop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="tb_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
    private Long id;

	@Getter @Setter
	private Long number;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@Getter @Setter
	private Customer customer;
	
	@Getter @Setter
	private String reason;
	
	@Getter @Setter
	private String service;
	
	@Getter @Setter
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> items;
	
	public void addItem(Item item) {
	  this.items.add(item);
	}
}
