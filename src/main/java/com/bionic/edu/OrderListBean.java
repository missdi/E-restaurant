package com.bionic.edu;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Named
@Scope("request")
	public class OrderListBean implements Serializable{
	
	private OrdersList orders;
	private List <OrdersList> ordersList;
	
	@Inject
	OrdersService ordersService;

	public OrderListBean() {	
	}

	public OrdersList getOrders() {
		return orders;
	}

	public void setOrders(OrdersList orders) {
		this.orders = orders;
	}

	public List<OrdersList> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<OrdersList> ordersList) {
		this.ordersList = ordersList;
	}
	
	@PostConstruct
	public void refreshList(){		
		ordersList = ordersService.getOrdersListKitchen();		
	}	
	
	public void setDone(int orderDetId, int orderId){	
		ordersService.changeDishStatus(orderDetId);
		List<OrderDetails> l = ordersService.changeOrderStatus(orderId);
		if (!(l.isEmpty())){
			ordersService.changeOrderStatus(orderId,(byte)3);	
			ordersService.setReadinessTime(orderId);
		}
		refreshList();
	}		
	
	
	
}
