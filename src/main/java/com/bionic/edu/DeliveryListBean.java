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
public class DeliveryListBean implements Serializable{
	private DeliveryList delivery;
	private List <DeliveryList> deliveryList;
	
	@Inject
	OrdersService ordersService;

	public DeliveryListBean() {	
	}

	public DeliveryList getDelivery() {
		return delivery;
	}

	public void setDelivery(DeliveryList delivery) {
		this.delivery = delivery;
	}

	public List<DeliveryList> getDeliveryList() {
		return deliveryList;
	}

	public void setDeliveryList(List<DeliveryList> deliveryList) {
		this.deliveryList = deliveryList;
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
	@PostConstruct
	public void refreshList(){		
		deliveryList = ordersService.getDeliveryList();
		for (DeliveryList o: deliveryList){
			System.out.println(o);
		}
	}
	
	public void changeOrderStatus(String id, String orderStatus){		
		int id1 = Integer.parseInt(id);
		int orderStatus1 = Integer.parseInt(orderStatus);		
		ordersService.changeOrderStatus(id1, orderStatus1);		
	}

}
