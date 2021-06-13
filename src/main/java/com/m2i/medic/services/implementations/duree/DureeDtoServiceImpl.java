package com.m2i.medic.services.implementations.duree;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.repositories.DureeRepository;
import com.m2i.medic.services.duree.DureeDtoService;

public class DureeDtoServiceImpl implements DureeDtoService{

	private ObjectMapper mapper;
	private DureeRepository dureeRepo;
	
	public DureeDtoServiceImpl(DureeRepository dureeRepo, ObjectMapper mapper) {
		this.dureeRepo = dureeRepo;
		this.mapper = mapper;
	}
	
	@Override
	public List<DureeDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DureeDto getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DureeDto save(DureeDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DureeDto updateById(DureeDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void deleteByID(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


}
