package com.bionic.edu;

import java.util.List;

import javax.inject.*;

import org.springframework.transaction.annotation.Transactional;

@Named
public class FoodCategoryServiceImpl implements FoodCategoryService{

	@Inject
	private FoodCategoryDao foodCatDAO;
	
	//method for adding new food category
	@Transactional
	public void add(FoodCategory foodCat) {
		foodCatDAO.add(foodCat);		
	}

	//method for editing food category name
	@Transactional
	public void editName(int id, String name) {
		foodCatDAO.editName(id, name);		
	}

	//method  to receive list of all food categories
	public List<FoodCategory> getFoodCatList() {		
		return foodCatDAO.getFoodCatList();
	}
	
	public FoodCategory getById (int id){
		return foodCatDAO.getById(id);
	}
	

}
