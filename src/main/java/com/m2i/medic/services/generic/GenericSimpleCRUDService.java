package com.m2i.medic.services.generic;

import java.util.List;

public interface GenericSimpleCRUDService<T> {

	public List<T> getAll();

	public T getById(String id);

	public void deleteByID(String id);

	public void deleteAll();
}
