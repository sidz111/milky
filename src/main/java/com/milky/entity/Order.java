package com.milky.entity;

import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String time;
	private Boolean isConfirmed;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "milk_id", nullable = true)
	private Milk milk;

	@ManyToOne
	@JoinColumn(name = "dairy_product_id", nullable = true)
	private DairyProduct dairyProduct;

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Boolean getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(Boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		if (!user.getOrders().contains(this)) {
			user.getOrders().add(this);
		}
	}

	public Milk getMilk() {
		return milk;
	}

	public void setMilk(Milk milk) {
		this.milk = milk;

		if (milk.getOrders() == null) {
			milk.setOrders(new ArrayList<>());
		}

		if (!milk.getOrders().contains(this)) {
			milk.getOrders().add(this);
		}
	}

	public void setDairyProduct(DairyProduct dairyProduct) {
		if(dairyProduct.getOrders() == null) {
			dairyProduct.setOrders(new ArrayList<>());
		}
		
		if(!dairyProduct.getOrders().contains(this)) {
			dairyProduct.getOrders().add(this);
		}
		this.dairyProduct = dairyProduct;
	}
	
	public DairyProduct getDairyProduct() {
		return this.dairyProduct;
	}

	
	


}
