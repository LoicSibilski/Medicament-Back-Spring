package com.m2i.medic.services.medic;

import java.util.List;

import com.m2i.medic.dtos.medic.SimpleMedicDto;

public interface SimpleMedicDtoService {

	public List<SimpleMedicDto> getAll();
	
	public SimpleMedicDto getById(String id);
			
	public void deleteByID(String id);

	public void deleteAll();

}
