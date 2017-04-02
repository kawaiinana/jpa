package com.jdc.jpa7.repo;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jdc.jpa7.entity.Product;

@SuppressWarnings("serial")
public class ProductRepo implements Serializable {

	@Inject
	private EntityManager em;

	public void add(Product p) {
		em.persist(p);
	}

	public void update(Product p) {
		em.merge(p);
	}

	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	public List<Product> find(String string, List<Object> params) {
		TypedQuery<Product> q = em.createQuery(string, Product.class);

		for (int i = 0; i < params.size(); i++) {
			q.setParameter(i + 1, params.get(i));
		}
		return q.getResultList();
	}
}
