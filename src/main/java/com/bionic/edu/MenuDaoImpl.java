package com.bionic.edu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class MenuDaoImpl implements MenuDao{

	@PersistenceContext
	private EntityManager em;

	//method for adding new dish to menu
	public void add(Menu menu) {
		em.persist(menu);		
	}

	//method for editing dishes in menu	
	public void editMenu(Menu menu){
		em.merge(menu);
	}
	
	//method for editing status of dish (active, non-active)	
	public void editStatus(int id, boolean status) {
		Menu menuOld = em.find(Menu.class, id);
		menuOld.setStatus(status);		
	}	
	
	//Method to choose menu list by Food Category
	public List<Menu> selectByFoodCat(int id) {
		TypedQuery<Menu> query = em.createQuery("SELECT m FROM Menu m WHERE m.foodCategory.id="+id, Menu.class);		
		return query.getResultList();
	}
	
	//Method to get Menu List
	public List<Menu> getMenuList() {
		TypedQuery<Menu> query = em.createQuery("SELECT m FROM Menu m", Menu.class);			
		return query.getResultList();		
	}		
	
	//Method to find id of the object
	public int getId (Menu menu){
		return menu.getId();
	}
	
	//Method to find object by id
	public Menu findById(int id){
		return em.find(Menu.class, id);
	}

	

	
	
	
}
