package com.bionic.edu;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
@Named
@Scope("session")
	public class FoodCatBean implements Serializable{	
	
	private List<FoodCategory> foodCat;	
	public FoodCategory foodCategory;	
	private MenuModel model;
	
	@Inject 
	private FoodCategoryService fcService;

	public FoodCatBean() {		
		foodCategory= new FoodCategory();		
	}	

	public List<FoodCategory> getFoodCat() {
		return foodCat;
	}

	public void setFoodCat(List<FoodCategory> foodCat) {
		this.foodCat = foodCat;
	}
		
	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}	
	
	public MenuModel getModel() {
		return model;
	}   
	
	@PostConstruct
	public void refreshList(){				
		foodCat = fcService.getFoodCatList();		
	}
	
	public void editFoodCategory(FoodCategory fc){
		fcService.editName(fc.getId(), fc.getFoodCatName());
	}
	
	 public void onCellEdit(CellEditEvent event) {
	        Object oldValue = event.getOldValue();
	        Object newValue = event.getNewValue();
	         
	        if(newValue != null && !newValue.equals(oldValue)) {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	            DataTable table = (DataTable) event.getSource();
	            FoodCategory fc = (FoodCategory) table.getRowData();
	            editFoodCategory(fc);
	            FacesContext.getCurrentInstance().addMessage(null, 
	                new FacesMessage(FacesMessage.SEVERITY_INFO,"Successfully Updated", 
	    "Updated value to " + newValue));  
	        }
	 }	
	  
	}
