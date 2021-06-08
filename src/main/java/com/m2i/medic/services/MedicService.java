package com.m2i.medic.services;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.dtos.CreationMedicDto;
import com.m2i.medic.models.Medic;

public interface MedicService extends GenericService<Medic>{

	public CreationMedicDto convertionJsonMedicVersCreationMedicDto(JsonNode medicTmp) throws JsonProcessingException, IllegalArgumentException, IOException;
	
}
