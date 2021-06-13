package com.m2i.medic.services.medic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.dtos.medic.SimpleMedicDto;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.services.GenericCRUDService;

public interface MedicDtoService extends GenericCRUDService<MedicDto>{

	public SimpleMedicDto save(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException;

	
}
