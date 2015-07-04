package com.bionic.edu;

import javax.persistence.*;
	
@Entity
public class OrderStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String orderStatusName;
		
	public OrderStatus() {		
	}
		
	
	//------------getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}
		
	//-----------------------------------------
	
}
