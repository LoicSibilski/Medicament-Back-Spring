package com.m2i.medic.services.generic;

public interface GenericModificationCRUDService <T>{

	public T save( T entity);

	public T updateById( T entity);
}
