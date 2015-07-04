package com.bionic.edu;

import java.util.List;

public interface FoodCategoryDao {
	public void add (FoodCategory foodCat);	
	public void editName (int id, String name);
	public List<FoodCategory> getFoodCatList();
	public FoodCategory getById (int id);
	;
	
}
