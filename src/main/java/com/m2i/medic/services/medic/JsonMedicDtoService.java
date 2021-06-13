package com.m2i.medic.services.medic;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.dtos.medic.SimpleMedicDto;

public interface JsonMedicDtoService {
	
	/**
	 * La methode permets de construire un dto creationMedicDto a partir du JSON
	 * envoye par l'utilisateur depuis le front.
	 * 
	 * @param jsonNode : JSON contenant toutes les informations et toutes les
	 *                 options possible.
	 * @return CreationMedicDto.
	 */
	public SimpleMedicDto createMedicDtoFromJsonNode(JsonNode jsonNode)
			throws JsonProcessingException, IllegalArgumentException ;
	
	/**
	 * La methode permets de construire un dto creationMedicDto a partir des
	 * elements en parametres.
	 * 
	 * @param nom         : String
	 * @param mapFreq     : Map<String, Object> : map contenant toutes les valeurs
	 *                    concernant la frequence. Cette map sera transformee en un
	 *                    objet FrequenceDto.
	 * @param mapDuree    : Map<String, Object> : map contenant toutes les valeurs
	 *                    concernant la duree. Cette map sera transformee en un
	 *                    objet DureeDto.
	 * @param listeHeures : List<LocalTime> : liste contenant les horaires de prise
	 *                    du medicaments.
	 * @return CreationMedicDto.
	 */
	public SimpleMedicDto createMedicDtoFromMaps(String nom, Map<String, Object> mapFreq, Map<String, Object> mapDuree,
			List<LocalTime> listeHeures);

}
