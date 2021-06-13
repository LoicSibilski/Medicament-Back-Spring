package com.m2i.medic.services;

import java.util.List;

public interface GenericCRUDService <T> {

	public List<T> getAll();
	
	public T getById(String id);
			
	public T save( T entity);

	public T updateById( T entity);
	
	public void deleteByID(String id);

	public void deleteAll();
}
