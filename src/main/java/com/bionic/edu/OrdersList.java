package com.bionic.edu;

import java.sql.Time;

public class OrdersList {
	private String foodCatName;
	private String dishName;
	private Time orderTime;	
	private int orderNum;
	private int orderDetId;
		
	public OrdersList() {		
	}
	
	public OrdersList(String foodCatName, String dishName, Time orderTime, int orderNum, int  orderDetId) {	
		this.foodCatName = foodCatName;
		this.dishName = dishName;
		this.orderTime = orderTime;
		this.orderNum = orderNum;
		this.orderDetId = orderDetId;
	}	

	@Override
	public String toString() {
		return "OrdersList [foodCatName=" + foodCatName + ", dishName="
				+ dishName + ", orderTime=" + orderTime + ", orderNum="
				+ orderNum + ", orderDetId=" + orderDetId + "]";
	}

	public String getFoodCatName() {
		return foodCatName;
	}

	public void setFoodCatName(String foodCatName) {
		this.foodCatName = foodCatName;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Time getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Time orderTime) {
		this.orderTime = orderTime;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderDetId() {
		return orderDetId;
	}

	public void setOrderDetId(int orderDetId) {
		this.orderDetId = orderDetId;
	}
		
	
}
