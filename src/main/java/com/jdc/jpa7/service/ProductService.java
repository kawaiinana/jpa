package com.jdc.jpa7.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jdc.jpa7.entity.Category;
import com.jdc.jpa7.entity.Product;
import com.jdc.jpa7.repo.ProductRepo;

@Local
@Stateless
@SuppressWarnings("serial")
public class ProductService implements Serializable {

	@Inject
	private ProductRepo repo;

	public void save(Product product) {
		if (product.getId() == 0) {
			repo.add(product);
		} else {
			repo.update(product);
		}

	}

	public List<Product> find(Category schCategory, double priceFrom, double priceTo) {

		StringBuffer sb = new StringBuffer("select p from Product p ");
		List<Object> params = new ArrayList<>();

		if (null != schCategory) {
			sb.append("where ");
			sb.append("p.category = ?" + (params.size() + 1) + " ");
			params.add(schCategory);

		}

		if (priceFrom > 0) {
			if (params.size() > 0) {
				sb.append("and ");
			} else {
				sb.append("where ");
			}
			sb.append("p.price >= ?" + (params.size() + 1) + " ");
			params.add(priceFrom);
		}

		if (priceTo > 0) {
			if (params.size() > 0) {
				sb.append("and ");
			} else {
				sb.append("where ");
			}
			sb.append("p.price <= ?" + (params.size() + 1) + " ");
			params.add(priceTo);
		}
		return repo.find(sb.toString(), params);
	}

}
