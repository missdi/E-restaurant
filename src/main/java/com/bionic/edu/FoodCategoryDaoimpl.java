package com.bionic.edu;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

@Repository
public class FoodCategoryDaoimpl implements FoodCategoryDao {
	
	@PersistenceContext
	private EntityManager em;
	
	//method for adding new food category
	public void add(FoodCategory foodCat) {
		em.persist(foodCat);		
	}

	//method for editing food category name
	public void editName(int id, String name) {
		FoodCategory fg = em.find(FoodCategory.class, id);
		if (fg!=null){
			fg.setFoodCatName(name);
		}
		else System.out.println("Unknown food category");			
	}

	//method  to receive list of all food categories	
	
	public List<FoodCategory> getFoodCatList() {
	TypedQuery<FoodCategory> query = em.createQuery("SELECT fc FROM FoodCategory fc", FoodCategory.class);			
		return query.getResultList();		
	}
	
	public FoodCategory getById (int id){		
		return em.find(FoodCategory.class, id);
	}
	
	
	

}
