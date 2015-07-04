package com.bionic.edu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class OrderStatusDaoImpl implements OrderStatusDao{
	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(OrderStatus orderStatus) {
		em.persist(orderStatus);		
	}
	
	public List<OrderStatus> getOrderStatusList() {
		TypedQuery<OrderStatus> query = em.createQuery("SELECT os FROM OrderStatus os WHERE os.id>2", OrderStatus.class);			
		return query.getResultList();		
	}
	
	
	
	
}
