package com.bionic.edu;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;






import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Named
@Scope("session")
	public class CartBean implements Serializable{
	private Menu menu = new Menu();	
	private List<Menu> cart = new ArrayList<Menu>();
	int qty = 0;
	
	@Inject
	MenuService menuService;

	public CartBean() {			
	}

	public List<Menu> getCart() {
		return cart;
	}

	public void setCart(List<Menu> cart) {
		this.cart = cart;
	}		

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String addToCart(String menuId){	
		int id = Integer.parseInt(menuId);
		menu = menuService.findById(id);
		cart.add(menu);		
		qty++;
		return "category";
	}
	
	public String removeFromCart(Menu menu){		
		cart.remove(menu);	
		qty--;
		return "cart";
	}
	
	public String getPriceTotal() {
	        int total = 0;	 
	        for(Menu m : cart) {
	            total += m.getDishPrice();
	        }	
	        System.out.println(total);
	        return new DecimalFormat("###,###.###").format(total);
	    }
	
	public String clearCart(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "main";
	}
	
	
	}
