package com.m2i.medic.services;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.models.Medic;
import com.m2i.medic.models.MedicTmp;

public interface MedicService extends GenericService<Medic>{

	public Medic convertTmpToReal(JsonNode medicTmp) throws JsonProcessingException, IllegalArgumentException, IOException;
	
}
