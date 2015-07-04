package com.bionic.edu;

import javax.inject.*;

import org.springframework.transaction.annotation.Transactional;

@Named
public class UsersServiceImpl implements UsersService{
	@Inject 
	UsersDao usersDao;

	// Method for adding new user
	@Transactional
	public void addUser(Users user) {
		usersDao.addUser(user);		
	}
	
	//Method for editing staff profile
	@Transactional
	public void editUser(Users user) {
		usersDao.editUser(user);		
	}
	
	//Method for changing password
	@Transactional
	public void editPasswod(int id, String password) {
		usersDao.editPasswod(id, password);		
	}
	
	//Method helps to find user by Id	
	public Users findById(int id) {		
		return usersDao.findById(id);
	}
	
	
	public Users getLogin(String login, String password){
		return usersDao.getLogin(login, password);
	}
	
	public Users checkLogin (String login){
		return usersDao.checkLogin(login);
	}
	
	public Users checkEmail (String email){
		return usersDao.checkEmail(email);
	}
		
	

}
