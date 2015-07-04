package com.bionic.edu;

import java.math.BigInteger;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean(name = "categoryConverterBean") 
@FacesConverter(value = "categoryConverter")
public class MenuBeanConverter implements Converter {

    @PersistenceContext(unitName = "luavipuPU")
    // I include this because you will need to 
    // lookup  your entities based on submitted values
    private transient EntityManager em;  

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
      // This will return the actual object representation
      // of your Category using the value (in your case 52) 
      // returned from the client side
      return em.find(FoodCategory.class, new BigInteger(value)); 
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {    
        
        FoodCategory category;
        category = (FoodCategory)o;
        return String.valueOf(category.getId());
    }

}