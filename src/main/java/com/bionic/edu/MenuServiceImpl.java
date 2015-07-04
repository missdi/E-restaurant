package com.bionic.edu;

import java.util.List;

import javax.inject.*;

import org.springframework.transaction.annotation.Transactional;

@Named
public class MenuServiceImpl implements MenuService {

	@Inject
	private MenuDao menuDao;
	
	@Transactional
	//method for adding new dish to menu
	public void add(Menu menu) {
		menuDao.add(menu);		
	}
	
	//method for editing dishes in menu	
	@Transactional
	public void editMenu(Menu menu) {
		menuDao.editMenu(menu);		
	}
	
	//method for editing status of dish (active, non-active)
	@Transactional
	public void editStatus(int id, boolean status) {
		menuDao.editStatus(id, status);		
	}
		
	//Method to choose menu list by Food Category
	public List<Menu> selectByFoodCat(int id) {		
		return menuDao.selectByFoodCat(id);
	}
	
	//Method to get Menu List
	public List<Menu> getMenuList() {	
		return menuDao.getMenuList();
	}
	
	//methods for testing
	//Method to find id of the object
	public int getId(Menu menu) {
		return menuDao.getId(menu);
	}
	
	//Method to find object by id
	public Menu findById(int id){
		return menuDao.findById(id);
	}
	//----------------------------------


	
	
	

}
