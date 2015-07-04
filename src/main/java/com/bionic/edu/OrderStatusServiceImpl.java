package com.bionic.edu;

import java.util.List;

import javax.inject.*;

import org.springframework.transaction.annotation.Transactional;

@Named
public class OrderStatusServiceImpl implements OrderStatusService{
	@Inject
	OrderStatusDao orderStatusDao;

	@Transactional
	public void add(OrderStatus orderStatus) {
		orderStatusDao.add(orderStatus);		
	}
	
	public List<OrderStatus> getOrderStatusList(){
		return orderStatusDao.getOrderStatusList();
	}
}
