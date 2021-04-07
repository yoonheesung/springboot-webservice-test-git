package com.skcc.study.jpa.sample.domain.order.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@Entity
public class Category {
	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private Category parent;
	
	@OneToMany(mappedBy =  "parent")
	private List<Category> child = new ArrayList<Category>();
	
	//실무에서는 @ManyToMany를 @OneToMany, @ManyToOne으로 변경해야한다.
	@ManyToMany
	@JoinTable(name = "CATEGORY_ITEM",
	joinColumns = @JoinColumn(name = "CATEGORY_ID"),
	inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
	private List<Item> items = new ArrayList<AbstractReadWriteAccess.Item>();
}
