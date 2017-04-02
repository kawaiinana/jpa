package com.jdc.jpa7.rescources;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.jpa7.entity.Category;

@Named
@RequestScoped
public class CategoryConverter implements Converter {
	
	@Inject
	private List<Category> categories;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent component, String value) {
		if(null != value){
			return categories.stream()
					.filter(c->c.getName().equals(value))
					.findAny().orElse(null);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent component, Object value) {
		if(null != value){
			Category c = (Category) value;
			return c.getName();
		}
		return null;
	}

}
