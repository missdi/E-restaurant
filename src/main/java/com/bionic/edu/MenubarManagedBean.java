package com.bionic.edu;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;


import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
@Named
@Scope("request")
	public class MenubarManagedBean implements Serializable{	
	
	private List<FoodCategory> foodCat;			
	private MenuModel model;
	
	@Inject 
	private FoodCategoryService fcService;		

	public List<FoodCategory> getFoodCat() {
		return foodCat;
	}

	public void setFoodCat(List<FoodCategory> foodCat) {
		this.foodCat = foodCat;
	}	
	
	public MenuModel getModel() {
		return model;
	}   
	
	
	public void refreshList(){				
		foodCat = fcService.getFoodCatList();		
	}

	@PostConstruct
	 public void getMenu() {
		System.out.println("foodcatservice"+fcService);
		refreshList();
		model = new DefaultMenuModel();
		DefaultSubMenu menu = new DefaultSubMenu("Menu");
		//DefaultMenuItem gallery = new  DefaultMenuItem("Gallery");
		//DefaultMenuItem delivery = new  DefaultMenuItem("Delivery");
		//DefaultMenuItem about = new DefaultMenuItem("About Us");
		DefaultMenuItem cart = new DefaultMenuItem("Go to cart");
		DefaultMenuItem open = null;		 		
		
		for(FoodCategory fc: foodCat){
			open = new DefaultMenuItem(fc.getFoodCatName());						
			open.setCommand("#{menuCatBean.getListByFoodCat("+fc.getId()+")}");	
			open.setAjax(false);			
			menu.addElement(open);
		}
		
		cart.setCommand("cart");
		
		this.model.addElement(menu);		
		//this.model.addElement(gallery);
		//this.model.addElement(delivery);
		//this.model.addElement(about);	
		this.model.addElement(cart);
	}
	    
	  
	
	  
	}
