package com.m2i.medic.services.medic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.dtos.medic.SimpleMedicDto;

public interface SimpleMedicDtoService {

	/**
	 * La methode permets de construire un dto creationMedicDto a partir du JSON envoye par l'utilisateur depuis le front.
	 * @param jsonNode : JSON contenant toutes les informations et toutes les options possible.
	 * @return CreationMedicDto.
	 */
	public SimpleMedicDto createMedicDtoFromJsonNode(JsonNode jsonNode) 
			throws JsonProcessingException, IllegalArgumentException;

}
