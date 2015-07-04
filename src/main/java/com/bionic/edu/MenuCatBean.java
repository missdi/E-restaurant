package com.bionic.edu;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
	public class MenuCatBean{		
		private List <Menu> menuList = new ArrayList<Menu>();
		
		private Menu menu;
		
		@Inject
		private MenuService menuService;			
				
		public MenuCatBean() {
			menu = new Menu();			
		}		
		
		public void refresh(){
			menuList = menuService.getMenuList();
		}

		public List<Menu> getMenuList() {
			return menuList;
		}

		public void setMenuList(List<Menu> menuList) {
			this.menuList = menuList;
		}			
		
		public Menu getMenu() {
			return menu;
		}

		public void setMenu(Menu menu) {
			this.menu = menu;
		}				
	

		public String getListByFoodCat(Long id){		
			menuList = menuService.selectByFoodCat((int)(long)id);		
			return "category.xhtml";
		}
		
		public void viewCars() {
			System.out.println("view cars");
	        RequestContext.getCurrentInstance().openDialog("goToCart.xhtml");
	    }
		
		
		 public void addMessage(String summary, String detail) {
		        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		        FacesContext.getCurrentInstance().addMessage(null, message);
		    }		
		 
		 public String goToCart(){
			 return "cart";
		 }
		 
		
}
