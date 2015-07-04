package com.bionic.edu;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class FoodCategory {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String foodCatName;
	
	@OneToMany(mappedBy="foodCategory", cascade=CascadeType.PERSIST)
	private Collection <Menu> menu;
	
	public FoodCategory() {		
	}	
	public FoodCategory(int id, String foodCatName) {		
		this.id = id;
		this.foodCatName = foodCatName;
	}

	//------------getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoodCatName() {
		return foodCatName;
	}

	public void setFoodCatName(String foodCatName) {
		this.foodCatName = foodCatName;
	}


	public Collection<Menu> getMenu() {
		return menu;
	}

	public void setMenu(Collection<Menu> menu) {
		this.menu = menu;
	}	
	
	@Override
	public String toString() {
		return "FoodCategory [id=" + id + ", foodCatName=" + foodCatName + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((foodCatName == null) ? 0 : foodCatName.hashCode());
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodCategory other = (FoodCategory) obj;
		if (foodCatName == null) {
			if (other.foodCatName != null)
				return false;
		} else if (!foodCatName.equals(other.foodCatName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}


	
	
	
	

}
