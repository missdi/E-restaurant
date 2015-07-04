package com.bionic.edu;

import javax.persistence.*;

@Entity
public class AccessRole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String accessRoleName;
	
	public AccessRole() {	
	}

	
	//------------getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessRoleName() {
		return accessRoleName;
	}

	public void setAccessRoleName(String accessRoleName) {
		this.accessRoleName = accessRoleName;
	}
	
	//--------------------------------------------------
	

}
