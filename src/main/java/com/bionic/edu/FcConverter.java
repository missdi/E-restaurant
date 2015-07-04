package com.bionic.edu;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@Scope("request")
public class FcConverter implements Converter {	
	
	@Inject
    private FoodCategoryService foodCat; 
	
    public FcConverter() {		
	}
		
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {		
	    if (submittedValue == null || submittedValue.isEmpty()) {
	        return null;
	    }
	    try {	       
	    	return foodCat.getById(Integer.valueOf(submittedValue));	        
	    } catch (NumberFormatException e) {
	        throw new ConverterException(new FacesMessage(String.format("%s is not a valid FoodCat ID", submittedValue)), e);
	    }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
	    if (modelValue == null) {
	        return "";
	    }
	    if (modelValue instanceof FoodCategory) {	    	
	        return String.valueOf(((FoodCategory) modelValue).getId());
	    } else {
	        throw new ConverterException(new FacesMessage(String.format("%s is not a valid FoodCat", modelValue)));
	    }
	}
}