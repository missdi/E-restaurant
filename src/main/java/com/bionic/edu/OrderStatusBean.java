package com.bionic.edu;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@Scope("request")
public class OrderStatusBean {
	private List<OrderStatus> osList;
	private OrderStatus os;
	
	@Inject
	private OrderStatusService osService;

	public OrderStatusBean() {		
	}

	public List<OrderStatus> getOsList() {
		return osList;
	}

	public void setOsList(List<OrderStatus> osList) {
		this.osList = osList;
	}

	public OrderStatus getOs() {
		return os;
	}

	public void setOs(OrderStatus os) {
		this.os = os;
	}
	
	@PostConstruct
	public void refreshList(){			
		osList = osService.getOrderStatusList();
	}	

}
