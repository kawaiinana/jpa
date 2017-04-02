package com.jdc.jpa7.rescources;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SuppressWarnings("serial")
public class EntityManagerProducer implements Serializable{

		@Produces
		@PersistenceContext(unitName="jpa7")
		private EntityManager em;
}
