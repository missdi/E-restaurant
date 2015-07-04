package com.bionic.edu;

import java.sql.Date;
import java.time.*;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-config.xml");
		FoodCategoryService foodCatService = context.getBean(FoodCategoryService.class);
		UsersService usersService = context.getBean(UsersService.class);
		OrdersService orderService = context.getBean(OrdersService.class);
		MenuService menuService = context.getBean(MenuService.class);
		
		OrderDetailsService odService = context.getBean(OrderDetailsService.class);
		OrderStatusService orStService = context.getBean(OrderStatusService.class);		
		
		//addAddress(27, usersService, custAddService);
		//addOrder(orderService, menuService);
		//selectMenu(menuService);
		//findOrderSum(odService);
		//getOrderReport (orderService);
		//addFoodCategory(foodCatService);
		//addMenu(menuService);
		//addOrderStatus(orStService);
		//addUser(usersService);		
		//getSum(orderService, java.sql.Date.valueOf(LocalDate.of(2015, Month.MAY,14)));
		//getSumFC (orderService, java.sql.Date.valueOf(LocalDate.of(2015, Month.MAY,14)), 3);
		//updateMenu(menuService);
		//System.out.println(menuService.findById(9));
		//getOrderListKitchen(orderService);
		//getDeliveryList(orderService);
		//changeOrderStatus(odService);
		
		//getSumQty(orderService, java.sql.Date.valueOf(LocalDate.of(2015, Month.MAY,14)));
		
		
	}
	
	/*public static void addAddress(int id, UsersService usersService, CustomerAddressService cAddSer){
		Users user = usersService.findById(id);
		CustomerAddress custAdd = new CustomerAddress();
		custAdd.setAddress("Mayakovskogo");
		custAdd.setDistrict("Desnyanskiy");	
		//custAdd.setDefaultValue((byte) 1);
		ArrayList<CustomerAddress> list = new ArrayList<CustomerAddress>();
		list.add(custAdd);
	//	user.setCustAd(list);
		custAdd.setUsers(user);		
		cAddSer.add(custAdd);
	}*/
	
	public static void addOrder(OrdersService orderService, MenuService menuService){		
		Orders order = new Orders();
		OrderDetails orderDetails = new OrderDetails();	
		OrderDetails orderDetails1 = new OrderDetails();	
		ArrayList<OrderDetails>list = new ArrayList<OrderDetails>();	
		
		LocalDate dt = LocalDate.of(2015, Month.MAY, 14);
		order.setOrderDate(java.sql.Date.valueOf(dt));
		order.setOrderStatusId(6);
		LocalTime tm = LocalTime.of(16, 20);
		order.setOrderTime(java.sql.Time.valueOf(tm));
		order.setUserId(26);
		//order.setCustomerAdId(4);			     
		
		Menu menu = menuService.findById(8);
		Menu menu2 = menuService.findById(9);	
		
		orderDetails.setMenu(menu);
		orderDetails.setDishPrice(menu.getDishPrice());
		orderDetails.setDishStatus((byte) 1);			
		
		orderDetails1.setMenu(menu2);
		orderDetails1.setDishPrice(menu2.getDishPrice());
		orderDetails1.setDishStatus((byte) 0);	
					     
		list.add(orderDetails);
		list.add(orderDetails1);
			    
		order.setOrderDetails(list);
		
		orderDetails.setOrders(order);
		orderDetails1.setOrders(order);
		     
		orderService.add(order);			   
	}
	
	public static void selectMenu (MenuService menuService){
		List<Menu> list = menuService.selectByFoodCat(2);
		for(Menu m:list){
			System.out.println(m);
		}		
	}
   
	/*public static void getOrderReport (OrdersService orderService){
		LocalDate ld1 = LocalDate.of(2015, 3, 25);
		LocalDate ld2 = LocalDate.of(2015, 4, 05);
		Date d1 = Date.valueOf(ld1);
		Date d2 = Date.valueOf(ld2);
		List<Orders> list = orderService.getOrderReport(d1, d2);
		for (Orders o:list){
			System.out.println(o);
		}
	}*/
	
	public static void addFoodCategory(FoodCategoryService foodCatService){
		FoodCategory fc = new FoodCategory();
		fc.setFoodCatName("Dessert");
		foodCatService.add(fc);
	}
	
	public static void addMenu(MenuService menuService){
		Menu menu = new Menu();
		menu.setDishName("Chocolate cake");
		menu.setDishPrice(45.00);
		
	//	menu.setKitchenStatus((byte) 1);
	//	menu.setStatus((byte) 1);	
		
		menuService.add(menu);
	}
	
	public static void addOrderStatus(OrderStatusService orStService){
		OrderStatus orSt = new OrderStatus();		
		orSt.setOrderStatusName("order done");
		orStService.add(orSt);
	}
	
	public static void addUser(UsersService usersService){
		 Users users = new Users();			 
		 users.setAccessRoleId(1);
		 users.setLogin("Semen");
		 users.setPassword("Semen1");
		 users.setUserName("Vasiliy");
		 users.setUserSurname("Semenov");
		 
		 usersService.addUser(users);
	}
	
	/*public static void getSum(OrdersService orderService, Date d){
		List<Report> list = orderService.getSumQty(d);
		for (Report r:list)
			System.out.println(r);
	}
	
	public static void getSumFC (OrdersService orderService, Date d, int foodCatId){
		List<Report> list = orderService.getSumQtyFoodCat(d, foodCatId);
		for (Report r:list)
			System.out.println(r);
	}*/
	
	public static void updateMenu(MenuService menuService){
		Menu menu = menuService.findById(9);		
		menu.setDishPrice(50.00);				
		menuService.editMenu(menu);
	}
	
	public static void getOrderListKitchen(OrdersService orderService){
		List <OrdersList> list = orderService.getOrdersListKitchen();
		for (OrdersList o: list){
			System.out.println(o);
		}
	}
	
	public static void getDeliveryList(OrdersService orderService){
		List<DeliveryList> list = orderService.getDeliveryList();
		for (DeliveryList d:list){
			System.out.println(d);
		}
	}
	
	public static void changeOrderStatus(OrdersService orderService){
		List<OrderDetails> list = orderService.changeOrderStatus(4);
		for (OrderDetails o: list){
			System.out.println(o);
		}
	}
	
	public static void getSumQty(OrdersService orderService, Date d){
		Long qty = orderService.getQtyDate(d);
		System.out.println(qty);
	}
	

}
