package com.bionic.edu;

import java.io.Serializable;
import java.sql.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Named
@Scope("request")
class DateBean implements Converter, Serializable{  

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {				
		    try {	
		    	String[] array = value.split("/"); 
				String newDate = array[2]+"-"+array[1]+"-"+array[0];				
		        Date convertedDate = Date.valueOf(newDate);
		        return convertedDate;
		    } 
		    catch (ArrayIndexOutOfBoundsException e) {
		        return null;
		    }
		    catch (Exception e) {
		        throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrect date of birth", "Please re-check"));
		    }
		}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		try{
		if (value==null) {
		        return null;
		    }
		    final Date date = (Date)value;		
		    String date1 = date.toString();
		    String[] array = date1.split("-"); 
		    String newDate = array[2]+"-"+array[1]+"-"+array[0];		   
		    return newDate;
		}
		catch (ArrayIndexOutOfBoundsException e) {
	        return null;
	    }
	}
	}
