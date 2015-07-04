package com.bionic.edu;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

@Repository
public class OrdersDaoImpl implements OrdersDao{

	@PersistenceContext
	EntityManager em;
	
	//Method to add new order
	public void add(Orders order) {
		em.persist(order);		
	}

	//Method to see report with orders info during time period
	public List<Report> getOrderReport(Date d1, Date d2) {
		String txt = "SELECT new com.bionic.edu.Report (count(DISTINCT o.id),sum(od.dishPrice)) FROM Orders o, OrderDetails od "
				+ "WHERE o.id=od.orders.id AND o.orderDate BETWEEN :d1 AND :d2 GROUP BY o.orderDate";
		TypedQuery<Report> query = em.createQuery(txt, Report.class);
		query.setParameter("d1", d1);
		query.setParameter("d2", d2);
		return query.getResultList();
	}	
	
	//Method to get total orders sum, qty in mentioned day
	public Report getSumQty(Date d){
		String txt = "SELECT new com.bionic.edu.Report (count(DISTINCT o.id),sum(od.dishPrice)) FROM Orders o, OrderDetails od "
				+ "WHERE o.id=od.orders.id AND o.orderDate = :d GROUP BY o.orderDate";
		TypedQuery<Report> query = em.createQuery(txt, Report.class);
		query.setParameter("d", d);
		return (Report) query.getSingleResult();
	}

	//Method to get total orders sum, qty in mentioned day by FoodCategory
	public Report getSumQtyFoodCat(Date d, int foodCatId) {
		String txt = "SELECT new com.bionic.edu.Report (count(DISTINCT o.id),sum(od.dishPrice)) FROM Orders o, OrderDetails od "
				+ "WHERE o.id=od.orders.id AND o.orderDate = :d AND od.menu.foodCategory.id = :fc GROUP BY o.orderDate";
		TypedQuery<Report> query = em.createQuery(txt, Report.class);
		query.setParameter("d", d);
		query.setParameter("fc", foodCatId);
		return query.getSingleResult();
	}
	
	//Method to get total orders sum, qty during period by FoodCategory
		public List<Report> getSumQtyFoodCatPeriod(Date d1, Date d2, int foodCatId) {
			String txt = "SELECT new com.bionic.edu.Report (count(DISTINCT o.id),sum(od.dishPrice)) FROM Orders o, OrderDetails od "
					+ "WHERE o.id=od.orders.id AND o.orderDate BETWEEN :d1 AND :d2 AND od.menu.foodCategory.id = :fc GROUP BY o.orderDate";
			TypedQuery<Report> query = em.createQuery(txt, Report.class);
			query.setParameter("d1", d1);
			query.setParameter("d2", d2);
			query.setParameter("fc", foodCatId);
			return query.getResultList();
		}

	//Method to get delivery pending list	
	public List<DeliveryList> getDeliveryList() {
		String txt = "SELECT new com.bionic.edu.DeliveryList (o.readyForShipTime, o.id, (SELECT os.id FROM OrderStatus os WHERE os.id = o.orderStatusId), (SELECT os.orderStatusName FROM OrderStatus os WHERE os.id = o.orderStatusId)) "
				+ "FROM Orders o "
				+ "WHERE o.orderStatusId  IN(3, 4)";
		TypedQuery <DeliveryList> query = em.createQuery(txt, DeliveryList.class);
		return query.getResultList();
	}

	//Method for changing order status
	public void changeOrderStatus(int orderId, int statusId) {
		Orders order = em.find(Orders.class, orderId);		
		order.setOrderStatusId(statusId);		
	}
	
	//Method for changing dish status
		public void changeDishStatus(int orderDetId) {
			OrderDetails orderDet = em.find(OrderDetails.class, orderDetId);			
			orderDet.setDishStatus((byte)1);			
		}

	//Method to filter orders by status
	public List<Orders> filterByStatus(int statusId) {
		TypedQuery <Orders> query = em.createQuery("SELECT o FROM Orders o WHERE o.orderStatusID="+statusId, Orders.class);
		return query.getResultList();
	}
	
	//Method to sort only kitchen-made dishes
	public List<OrdersList> getOrdersListKitchen() {
		String txt = "SELECT new com.bionic.edu.OrdersList (od.menu.foodCategory.foodCatName, od.menu.dishName, o.orderTime, o.id, od.id) FROM OrderDetails od, Orders o "
				+ "WHERE od.menu.kitchenStatus =1 AND od.dishStatus = 0 AND o.id = od.orders.id ORDER BY o.orderTime";
		TypedQuery<OrdersList> query = em.createQuery(txt, OrdersList.class);	
		return query.getResultList();
	}
	
	//Method to change dishStatus to done
		public List<OrderDetails> changeOrderStatus(int id) {				
			String txt = "SELECT od FROM OrderDetails od WHERE 0 < ALL(SELECT od.dishStatus FROM OrderDetails od WHERE od.orders.id=:id)";
			TypedQuery<OrderDetails> query = em.createQuery(txt, OrderDetails.class);		
			query.setParameter("id", id);
			return query.getResultList();
		}		
	
	//Method to get orders qty in mentioned day
		public long getQtyDate(Date d){	
			try{
			String txt = "SELECT count(o.id) FROM Orders o WHERE o.orderDate = :d GROUP BY o.orderDate";			
			TypedQuery <Long> query = em.createQuery(txt, Long.class);
			query.setParameter("d", d);
			return query.getSingleResult();		}
			catch (NoResultException e){
				return 0;
			}
		}
		
	//Method to get orders sum in mentioned day
		public double getSumDate(Date d){	
			try{
			String txt = "SELECT sum(od.dishPrice) FROM OrderDetails od WHERE od.orders.orderDate = :d GROUP BY od.orders.orderDate";			
			TypedQuery <Double> query = em.createQuery(txt, Double.class);
			query.setParameter("d", d);
			return query.getSingleResult();		
			}
			catch(NoResultException e){
				return 0;
			}
		}
		
		//Method to set readiness time of whole order
		public void setReadinessTime (int orderId){
			Orders order = em.find(Orders.class, orderId);
			order.setReadyForShipTime(Time.valueOf(LocalTime.now()));
		}
		
		//Method to get all orderDetails by orderId
		public List<OrderDetails> getOrdersListById(int orderId) {		
			String txt = "SELECT od FROM OrderDetails od WHERE od.orders.id ="+orderId;
			TypedQuery<OrderDetails> query = em.createQuery(txt, OrderDetails.class);	
			return query.getResultList();
		}
		
		//Method to get orders sum in mentioned day by FoodCategory
		public double getSumDateFC(Date d, int foodCatId){	
			try{
				String txt = "SELECT sum(od.dishPrice) FROM OrderDetails od WHERE od.orders.orderDate = :d AND od.menu.foodCategory.id = :fc GROUP BY od.orders.orderDate";			
				TypedQuery <Double> query = em.createQuery(txt, Double.class);
				query.setParameter("d", d);
				query.setParameter("fc", foodCatId);
				return query.getSingleResult();		
			}
			catch(NoResultException e){
				return 0;
			}
		}
				
		//Method to get orders qty in mentioned day by FoodCategory
				public long getQtyDateFC(Date d, int foodCatId){	
					try{
					String txt = "SELECT count(DISTINCT o.id) FROM Orders o, OrderDetails od WHERE o.id=od.orders.id AND o.orderDate = :d AND od.menu.foodCategory.id = :fc GROUP BY o.orderDate";			
					TypedQuery <Long> query = em.createQuery(txt, Long.class);
					query.setParameter("d", d);
					query.setParameter("fc", foodCatId);
					return query.getSingleResult();		}
					catch (NoResultException e){
						return 0;
					}
				}

}
