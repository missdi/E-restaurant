package com.bionic.edu;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
public class Users implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String login;
	private String password;
	private int accessRoleId;
	private String userName;
	private String userSurname;		
	private String userEmail;	
	private Date userDB;
	private String userPhone;	
	private String address;
	
	public Users() {		
	}
	
	//------------getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccessRoleId() {
		return accessRoleId;
	}

	public void setAccessRoleId(int accessRoleId) {
		this.accessRoleId = accessRoleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserDB() {
		return userDB;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", login=" + login + ", password="
				+ password + ", accessRoleId=" + accessRoleId + ", userName="
				+ userName + ", userSurname=" + userSurname + ", userEmail="
				+ userEmail + ", userDB=" + userDB + ", userPhone=" + userPhone
				+ ", address=" + address + "]";
	}

	public void setUserDB(Date userDB) {
		this.userDB = userDB;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setaccessRoleIdUser(){
		accessRoleId = 1;
	}
	
	
	
	
	//--------------------------------------------
	

}
