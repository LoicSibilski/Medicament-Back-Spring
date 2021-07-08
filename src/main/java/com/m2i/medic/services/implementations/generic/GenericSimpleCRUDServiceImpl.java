package com.m2i.medic.services.implementations.generic;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.m2i.medic.services.generic.GenericSimpleCRUDService;

public class GenericSimpleCRUDServiceImpl<T> implements GenericSimpleCRUDService<T>{

	private MongoRepository<T, String> repository;
	
	public GenericSimpleCRUDServiceImpl(MongoRepository<T, String> repository) {
		this.repository = repository;
	}

	@Override
	public T getById(String id) {
		T entity = this.repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		return entity;
	}

	@Override
	public List<T> getAll() {
		return this.repository.findAll();
	}
	
	@Override
	public void deleteByID(String id) {
		if(this.repository.existsById(id))
			this.repository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@Override
	public void deleteAll() {
		this.repository.deleteAll();
	}

}