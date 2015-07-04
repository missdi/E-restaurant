package com.bionic.edu;

import java.io.Serializable;


import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Named
@Scope("session")
public class UserBean implements Serializable{
	
	private boolean skip;
	private Users user = new Users();	
	boolean disable;
	
	@Inject
	private UsersService usersService;
	
	
	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}	
	
	public boolean isDisable() {		
		try{
		if (user.getId() != 0){
			 return true;
		 }		 
		else return false;}
		catch (NullPointerException e){
			return false;
		}
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }	

	public void save(){
		usersService.addUser(user);
		FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getUserName());
        FacesContext.getCurrentInstance().addMessage(null, msg);      
       
	}
	
	public String getLogin(String login, String password){		
		user = usersService.getLogin(login, password);		
		return "orderConfirm";
	}
	
	public String getLogin(){				
		user = usersService.getLogin(user.getLogin(), user.getPassword());	
		if(user==null){
			user=usersService.findById(38);		
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Incorrect e-mail or password"));
		return "login";		}
		else return "orderConfirm";		
	}
	
	public int getUserId(){
		return user.getId();
	}

	public void ajaxListener(AjaxBehaviorEvent event) {
		if(user.getAccessRoleId()==0){
			user.setAccessRoleId(1);
		}
		usersService.editUser(user);	  
	}
	
	public String redirectOrderConf(){
		try{
			if (user.getId() != 0){
				 return "orderConfirm";
			 }		 
			else return "orderConfNoAutorized";
			}
			catch (NullPointerException e){
				return "orderConfNoAutorized";
			}
	}	
	
	public void loginListener(AjaxBehaviorEvent event) {		
		Users userCheck = usersService.checkLogin(user.getLogin());
		if (userCheck!=null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login is already existed", "Please choose another login"));
		}		  
	}
	
	public void emailListener(AjaxBehaviorEvent event) {		
		Users userCheck = usersService.checkEmail(user.getUserEmail());
		if (userCheck!=null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Email is already registered", "Please enter another email"));
		}		  
	}
	
	public void checkDB (AjaxBehaviorEvent event){
		Date d = user.getUserDB();
		LocalDate db = d.toLocalDate();
		LocalDate today = LocalDate.now();
		long days = ChronoUnit.DAYS.between(db, today);
		if (days<0||days>29900){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect date of birth", "Please re-check!!!"));
		}
				
	}
	
}
