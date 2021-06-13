package com.m2i.medic.services.medic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.dtos.medic.MedicDto;

public interface ModificationMedicService {
	
	public MedicDto save(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException;

	public MedicDto update(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException;

	
}
