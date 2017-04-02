package com.jdc.jpa7.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.jpa7.entity.Category;
import com.jdc.jpa7.entity.Product;
import com.jdc.jpa7.service.ProductService;

@ViewScoped
@Named
@SuppressWarnings("serial")
public class ProductListBean implements Serializable {

	private Category schCategory;

	private double priceFrom;

	private double priceTo;

	private List<Product> products;

	@Inject
	private ProductService service;

	@PostConstruct
	public void init() {
		search();
	}

	public void search() {
		products = service.find(schCategory, priceFrom, priceTo);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category getSchCategory() {
		return schCategory;
	}

	public void setSchCategory(Category schCategory) {
		this.schCategory = schCategory;
	}

	public double getPriceFrom() {
		return priceFrom;
	}

	public void setPriceFrom(double priceFrom) {
		this.priceFrom = priceFrom;
	}

	public double getPriceTo() {
		return priceTo;
	}

	public void setPriceTo(double priceTo) {
		this.priceTo = priceTo;
	}

}
