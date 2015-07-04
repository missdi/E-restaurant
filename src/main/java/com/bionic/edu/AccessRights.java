package com.bionic.edu;

import javax.persistence.*;

@Entity
public class AccessRights {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int accessRoleId;
	private int accessUnitId;
	private byte accessStatus;	
	
	public AccessRights() {	
	}
	
	//------------getters/setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccessRoleId() {
		return accessRoleId;
	}
	public void setAccessRoleId(int accessRoleId) {
		this.accessRoleId = accessRoleId;
	}
	public int getAccessUnitId() {
		return accessUnitId;
	}
	public void setAccessUnitId(int accessUnitId) {
		this.accessUnitId = accessUnitId;
	}
	public byte getAccessStatus() {
		return accessStatus;
	}
	public void setAccessStatus(byte accessStatus) {
		this.accessStatus = accessStatus;
	}
	
	//------------------------------------------------

}
