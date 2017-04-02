package com.jdc.jpa7.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.jpa7.entity.Product;
import com.jdc.jpa7.service.ProductService;

@Model
public class ProductNewBean {

	private Product product;

	@Inject
	private ProductService service;

	@PostConstruct
	private void init() {
		product = new Product();
	}

	public String save() {
		service.save(product);
		return "products?faces-redirect=true";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
