package com.bionic.edu;

import java.sql.Date;
import java.util.List;

public interface OrdersService {
	public void add (Orders order);
	public List<Report> getOrderReport (Date d1, Date d2);
	public Report getSumQty(Date d);
	public Report getSumQtyFoodCat(Date d, int foodCatId);
	public List<DeliveryList> getDeliveryList();
	public void changeOrderStatus(int orderId, int statusId);
	public List<Orders> filterByStatus (int statusId);
	public List<OrdersList> getOrdersListKitchen();
	public List<OrderDetails> changeOrderStatus(int id);
	public void changeDishStatus(int orderDetId);
	public long getQtyDate(Date d);
	public void setReadinessTime (int orderId);
	public List<OrderDetails> getOrdersListById(int orderId);
	public double getSumDate(Date d);
	public List<Report> getSumQtyFoodCatPeriod(Date d1, Date d2, int foodCatId);
	public double getSumDateFC(Date d, int foodCatId);
	public long getQtyDateFC(Date d, int foodCatId);
}
	
