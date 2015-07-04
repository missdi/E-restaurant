package com.bionic.edu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class UsersDaoImpl implements UsersDao {

	@PersistenceContext
	private EntityManager em;
	
	// Method for adding new user
	public void addUser(Users user) {
		em.persist(user);				
	}

	//Method for editing staff profile
	public void editUser(Users user) {
		em.merge(user);
	}
	
	//Method for changing password
	public void editPasswod(int id, String password) {
		Users user = em.find(Users.class, id);
		if (user!=null){
			user.setPassword(password);
		}		
	}

	//Method helps to find user by Id
	public Users findById(int id) {
		return em.find(Users.class, id);		
	}
	
	public Users getLogin(String login, String password){
		try{
			String txt = "SELECT user FROM Users user WHERE user.login=:login AND user.password=:password";
			TypedQuery<Users> query = em.createQuery(txt, Users.class);		
			query.setParameter("login", login);
			query.setParameter("password", password);		
			return query.getSingleResult();		
		}
		catch (Exception e){
			return null;
		}		
	}
	
	public Users checkLogin (String login){
		try{
			String txt = "SELECT user FROM Users user WHERE user.login=:login";
			TypedQuery<Users> query = em.createQuery(txt, Users.class);	
			query.setParameter("login", login);
			return query.getSingleResult();
		}
		catch (Exception e){
			return null;
		}		
	}
	
	public Users checkEmail (String email){
		try{
			String txt = "SELECT user FROM Users user WHERE user.userEmail=:email";
			TypedQuery<Users> query = em.createQuery(txt, Users.class);	
			query.setParameter("email", email);
			return query.getSingleResult();
		}
		catch (Exception e){
			return null;
		}		
	}
	
}
