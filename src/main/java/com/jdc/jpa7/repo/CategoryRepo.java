package com.jdc.jpa7.repo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jdc.jpa7.entity.Category;

@SuppressWarnings("serial")
public class CategoryRepo implements Serializable {

	@Inject
	private EntityManager em;
	
	@Inject
	private Event<Category> event;
	

	public void create(Category c) {
		em.persist(c);
		event.fire(c);
	}

	public void update(Category c) {
		em.merge(c);
		event.fire(c);
	}

	public List<Category> findAll() {
		return em.createNamedQuery("Category.findAll", Category.class).getResultList();
	}
}
