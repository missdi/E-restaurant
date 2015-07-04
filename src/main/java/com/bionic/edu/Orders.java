package com.bionic.edu;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Orders {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int  userId;	
	private Date orderDate;
	private Time orderTime;
	private int orderStatusId;
	private String customerAdd;
	private String customerPhone;
	private String comment;
	private Time readyForShipTime;
	
	@OneToMany(mappedBy="orders", 	cascade=CascadeType.PERSIST)
    private Collection <OrderDetails> orderDetails;
		
	public Orders() {	
	}
	
	//------------getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Time getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Time orderTime) {
		this.orderTime = orderTime;
	}

	public int getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public Collection<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Collection<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getCustomerAdd() {
		return customerAdd;
	}

	public void setCustomerAdd(String customerAdd) {
		this.customerAdd = customerAdd;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
		
	public Time getReadyForShipTime() {
		return readyForShipTime;
	}

	public void setReadyForShipTime(Time readyForShipTime) {
		this.readyForShipTime = readyForShipTime;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

		
	//--------------------------------------------------


@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", orderDate="
				+ orderDate + ", orderTime=" + orderTime + ", orderStatusId="
				+ orderStatusId + ", customerAdd=" + customerAdd
				+ ", comment=" + comment + ", orderDetails=" + orderDetails
				+ "]";
	}	
	

}
