package com.bionic.edu;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Menu {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String  dishName;
	private double  dishPrice;
	private boolean  kitchenStatus;
	private boolean status;
	private String description;
	@Lob
	private byte[] cover;

	
	@OneToMany(mappedBy="menu", cascade=CascadeType.PERSIST)
   private Collection <OrderDetails> orderDetails;
	
	@ManyToOne
	@JoinColumn(name="foodCatId")
	private FoodCategory foodCategory;	
	
	public Menu() {	
		foodCategory = new FoodCategory();
	}
		
	//------------getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public double getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}

	public boolean getKitchenStatus() {
		return kitchenStatus;
	}

	public void setKitchenStatus(boolean kitchenStatus) {
		this.kitchenStatus = kitchenStatus;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
		
	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Collection<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}		
		
	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}
	
	//---------------------------------
	
	public String toString() {
		return "Menu [id=" + id + ", dishName="
				+ dishName + ", dishPrice=" + dishPrice + ", kitchenStatus="
				+ kitchenStatus + ", status=" + status + "]";
	}

	

}
