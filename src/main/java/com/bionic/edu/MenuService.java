package com.bionic.edu;

import java.util.List;

public interface MenuService{
	public void add (Menu menu);	
	public void editMenu (Menu menu);
	public void editStatus (int id, boolean status);
	public List<Menu> getMenuList();
	
	public List<Menu> selectByFoodCat(int id);
	
	public int getId (Menu menu);
	public Menu findById(int id);
}
