package com.jdc.jpa7.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.jpa7.entity.Category;
import com.jdc.jpa7.service.CategoryService;

@Model
public class CategoryBean{
	
	private Category newCategory;
	private List<Category> categories;
	
	@Inject
	private CategoryService service;
	
	@PostConstruct
	private void load(){
		newCategory = new Category();
		categories = service.findAll();
	}
	
	public String save(){
		service.save(newCategory);
		return "categories?faces-redirect=true";
	}

	public Category getNewCategory() {
		return newCategory;
	}

	public void setNewCategory(Category newCategory) {
		this.newCategory = newCategory;
	}

	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
