package com.m2i.medic.services.medic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.dtos.medic.SimpleMedicDto;

public interface ModificationMedicService {
	
	public SimpleMedicDto save(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException;

	public SimpleMedicDto update(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException;

	
}
