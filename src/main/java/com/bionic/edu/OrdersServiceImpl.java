package com.bionic.edu;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.inject.*;
import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

@Named
public class OrdersServiceImpl implements OrdersService{
	@Inject
	private OrdersDao ordersDao;
	
	//Method to add new order
	@Transactional
	public void add(Orders order) {
		ordersDao.add(order);		
	}
	
	//Method to see report with orders info during time period
	public List<Report> getOrderReport(Date d1, Date d2) {		
		try{
		return ordersDao.getOrderReport(d1, d2);
		}
		catch (NoResultException e){
			Report r = new Report();
			List<Report> reportList = new ArrayList<Report>();
			r.setQty(0);
			r.setSum(0);
			reportList.add(r);
			return reportList;
		}
	}
		
	//Method to get total orders sum, qty in mentioned day
	public Report getSumQty(Date d) {	
		try{
		return ordersDao.getSumQty(d);
		}
		catch (NoResultException e){
			Report r = new Report();
			r.setQty(0);
			r.setSum(0);
			return r;
		}
	}

	//Method to get total orders sum, qty in mentioned day by FoodCategory
	public Report getSumQtyFoodCat(Date d, int foodCatId) {		
	try{
		return ordersDao.getSumQtyFoodCat(d, foodCatId);
	}
	catch (NoResultException e){
		Report r = new Report();
		r.setQty(0);
		r.setSum(0);
		return r;
	}
	
	}
	
	//Method to get delivery pending list
	public List<DeliveryList> getDeliveryList() {		
		return ordersDao.getDeliveryList();
	}
	
	//Method for changing order status
	@Transactional
	public void changeOrderStatus(int orderId, int statusId) {
		ordersDao.changeOrderStatus(orderId, statusId);		
	}

	//Method to filter orders by status
	public List<Orders> filterByStatus(int statusId) {		
		return ordersDao.filterByStatus(statusId);
	}
	

	//Method to sort only kitchen-made dishes
	public List<OrdersList> getOrdersListKitchen() {		
		return ordersDao.getOrdersListKitchen();
	}
	
	@Transactional
	public List<OrderDetails> changeOrderStatus(int id) {		
		return ordersDao.changeOrderStatus(id);
	}
	
	@Transactional
	public void changeDishStatus(int orderDetId){
		ordersDao.changeDishStatus(orderDetId);
	}
	
	public long getQtyDate(Date d){		
		try {
			return ordersDao.getQtyDate(d);
		}
		catch (NullPointerException e){
			return 0;
		}
	}
	
	@Transactional
	public void setReadinessTime (int orderId){
		ordersDao.setReadinessTime(orderId);
	}
	
	public List<OrderDetails> getOrdersListById(int orderId){
		return ordersDao.getOrdersListById(orderId);
	}
	
	public double getSumDate(Date d){
		try {
			return ordersDao.getSumDate(d);
		}
		catch (Exception e){
			return 0;
		}
	}
	
	public List<Report> getSumQtyFoodCatPeriod(Date d1, Date d2, int foodCatId){
		return ordersDao.getSumQtyFoodCatPeriod(d1, d2, foodCatId);
	}
	
	public double getSumDateFC(Date d, int foodCatId){
		try {
			return ordersDao.getSumDateFC(d, foodCatId);
		}
		catch (Exception e){
			return 0;
		}
	}
	
	public long getQtyDateFC(Date d, int foodCatId){
		try {
			return ordersDao.getQtyDateFC(d, foodCatId);
		}
		catch (Exception e){
			return 0;
		}
	}
}
