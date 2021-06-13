package com.m2i.medic.services.medic;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.dtos.medic.SimpleMedicDto;

public interface SimpleMedicDtoService {

	public List<SimpleMedicDto> getAll();
	
	public SimpleMedicDto getById(String id);
			
	public void deleteByID(String id);

	public void deleteAll();

}
