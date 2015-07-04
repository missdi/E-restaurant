package com.bionic.edu;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Named
@Scope("session")
public class OrderBean implements Serializable{
	
	Orders order = new Orders();
	
	List<OrderDetails> orderDetList = new ArrayList<OrderDetails>();
	List<OrderDetails> forDelivery = new ArrayList<OrderDetails>();
	
	@Inject
	OrdersService ordersService;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}	
		
	/*public OrderDetails getOrderDet() {
		return orderDet;
	}

	public void setOrderDet(OrderDetails orderDet) {
		this.orderDet = orderDet;
	}*/
	
	public List<OrderDetails> getOrderDetList() {
		return orderDetList;
	}

	public void setOrderDetList(List<OrderDetails> orderDetList) {
		this.orderDetList = orderDetList;
	}
	
	

	public List<OrderDetails> getForDelivery() {
		return forDelivery;
	}

	public void setForDelivery(List<OrderDetails> forDelivery) {
		this.forDelivery = forDelivery;
	}

	public void save(List<Menu> menu){	
		setMenuOrderDetails(menu);
		order.setOrderDate(Date.valueOf(LocalDate.now()));
		order.setOrderTime(Time.valueOf(LocalTime.now()));
		order.setOrderStatusId(1);		
		for(OrderDetails od: orderDetList){
			od.setOrders(order);		
		}
		ordersService.add(order);
		FacesMessage msg = new FacesMessage("Thank you for your order. Our customer service specialist will contact with you within an hour");
        FacesContext.getCurrentInstance().addMessage(null, msg);           
	}
	
	public void saveNoAut(List<Menu> menu){	
		setMenuOrderDetails(menu);
		order.setOrderDate(Date.valueOf(LocalDate.now()));
		order.setOrderTime(Time.valueOf(LocalTime.now()));
		order.setOrderStatusId(1);
		order.setUserId(38);
		for(OrderDetails od: orderDetList){
			od.setOrders(order);		
		}
		ordersService.add(order);
		FacesMessage msg = new FacesMessage("Thank you for your order. Our customer service specialist will contact with you within an hour");
        FacesContext.getCurrentInstance().addMessage(null, msg);           
	}
	
	public void setMenuOrderDetails(List<Menu> menu){		
		for(Menu m: menu){
			OrderDetails orderDet = new OrderDetails();
			orderDet.setMenu(m);
			System.out.println(m);
			orderDet.setDishPrice(m.getDishPrice());
			orderDet.setDishStatusAdv(m);
			orderDetList.add(orderDet);			
		}
		order.setOrderDetails(orderDetList);		
	}
	
	public void getOrderListById (int id){
		
		forDelivery = ordersService.getOrdersListById(id);
		
	}

}
