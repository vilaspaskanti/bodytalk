package org.gym.dao.impl;

import java.io.Serializable;

import org.gym.dao.GenericDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoImpl<K, E> implements GenericDao<K, E>{
	
	@Autowired
	SessionFactory sessionFactory;
	
	Class<E> entityClass;
	
	@Override
	public E save(E object) {
		sessionFactory.getCurrentSession().save(object);
		return object;
	}

	@Override
	public E update(E object) {
		sessionFactory.getCurrentSession().update(object);
		return object;
	}

	@Override
	public void delete(E object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E fetchEntityById(K id) {
		return (E)sessionFactory.getCurrentSession().get(entityClass , (Serializable) id);
	}

}
