package com.bionic.edu;

import javax.persistence.*;

@Entity
public class AccessUnits {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String accessUnitName;
	
	public AccessUnits() {	
	}

	//------------getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessUnitName() {
		return accessUnitName;
	}

	public void setAccessUnitName(String accessUnitName) {
		this.accessUnitName = accessUnitName;
	}
	//---------------------------------------
	

}
