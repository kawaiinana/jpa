package com.jdc.jpa7.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jdc.jpa7.entity.Category;
import com.jdc.jpa7.repo.CategoryRepo;

@Local
@Stateless
public class CategoryService{
	
	@Inject
	private CategoryRepo repo;
	
	public void save(Category c){
		if(c.getId() == 0){
			repo.create(c);
		}else{
			repo.update(c);
		}
			
	}
	
	public List<Category> findAll(){
		return repo.findAll();
		
	}
}
