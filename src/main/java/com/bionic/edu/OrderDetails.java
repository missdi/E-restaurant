package com.bionic.edu;

import javax.persistence.*;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;		
	private byte dishStatus;
	private double dishPrice;	
	
    @ManyToOne
    @JoinColumn(name="orderId")
    private Orders orders;	
    
    @ManyToOne
    @JoinColumn(name="dishId")
    private Menu menu;	

	public OrderDetails() {	
	}	
	
	//------------getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public byte getDishStatus() {
		return dishStatus;
	}
	
	public void setDishStatus(byte dishStatus) {
		this.dishStatus = dishStatus;
	}

	public void orderDetId(byte dishStatus) {
		this.dishStatus = dishStatus;
	}


	public double getDishPrice() {
		return dishPrice;
	}


	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}
	
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void setDishStatusAdv(Menu menu){
		if(menu.getKitchenStatus())
		{
			setDishStatus((byte)0);		
		}
		else{
			setDishStatus((byte)1);	
		}
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", dishStatus=" + dishStatus
				+ ", dishPrice=" + dishPrice + ", orders=" + orders + ", menu="
				+ menu + "]";
	}

	
	
	
	//---------------------------------------------
	

}
