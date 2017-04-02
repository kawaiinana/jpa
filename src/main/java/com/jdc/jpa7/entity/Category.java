package com.jdc.jpa7.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@SuppressWarnings("serial")
@NamedQuery(name = "Category.findAll", query = "select c from Category c")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	
	@NotEmpty(message="Category Name must not empty")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
