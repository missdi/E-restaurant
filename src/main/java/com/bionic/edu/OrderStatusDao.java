package com.bionic.edu;

import java.util.List;

public interface OrderStatusDao {
	public void add (OrderStatus orderStatus);
	public List<OrderStatus> getOrderStatusList();
}
