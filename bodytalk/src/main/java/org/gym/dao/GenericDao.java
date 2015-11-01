package org.gym.dao;

public interface GenericDao<K,E> {

	public E save(E object);
	
	public E update(E object);
	
	public void delete(E object);
	
	public E fetchEntityById(K id);
	
}
