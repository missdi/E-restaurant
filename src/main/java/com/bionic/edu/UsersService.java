package com.bionic.edu;

public interface UsersService {
	public void addUser(Users user);
	public void editUser (Users user);		
	public void editPasswod (int id, String password);
	public Users findById(int id);
	public Users getLogin(String login, String password);
	public Users checkLogin (String login);
	public Users checkEmail (String email);
}
