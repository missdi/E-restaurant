package com.bionic.edu;

import java.sql.Time;

public class DeliveryList {
	private Time readinessTime;
	private int orderId;
	private int orderStatusId;
	private String orderStatusName;	
	
	public DeliveryList() {	
	}		
	
	public DeliveryList(Time readinessTime, int orderId, int orderStatusId, String orderStatusName) {		
		this.readinessTime = readinessTime;
		this.orderId = orderId;
		this.orderStatusId = orderStatusId;	
		this.orderStatusName = orderStatusName;
	}


	public Time getReadinessTime() {
		return readinessTime;
	}

	public void setReadinessTime(Time readinessTime) {
		this.readinessTime = readinessTime;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
		
	
	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	@Override
	public String toString() {
		return "DeliveryList [readinessTime=" + readinessTime + ", orderId="
				+ orderId + ", orderStatus=" + orderStatusId + ", dishName="
				 + ", dishPrice=" + "]";
	}

	
	
	
	
	
}
