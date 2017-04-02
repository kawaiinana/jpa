package com.jdc.jpa7.rescources;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.jpa7.entity.Category;
import com.jdc.jpa7.service.CategoryService;

@ApplicationScoped
public class CategoryProducer {
	@Named
	@Produces
	private List<Category> categories;
	
	@Inject
	private CategoryService service;
	
	@PostConstruct
	private void init(){
		categories = service.findAll();
	}

	public void load(@Observes Category c){
		categories = service.findAll();
	}
}
