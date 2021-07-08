package com.m2i.medic.services.generic;

import java.util.List;

public interface GenericSimpleCRUDService<T> {

	public T getById(String id);

	public List<T> getAll();

	void deleteByID(String id);

	public void deleteAll();

}