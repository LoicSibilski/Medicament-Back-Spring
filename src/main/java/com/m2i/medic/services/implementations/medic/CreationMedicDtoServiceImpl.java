package com.m2i.medic.services.implementations.medic;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.dtos.duree.CreationDureeDto;
import com.m2i.medic.dtos.frequence.CreationFrequenceDto;
import com.m2i.medic.dtos.medic.CreationMedicDto;
import com.m2i.medic.services.JsonNodeService;
import com.m2i.medic.services.medic.CreationDureeDtoService;
import com.m2i.medic.services.medic.CreationFrequenceDtoService;
import com.m2i.medic.services.medic.CreationMedicDtoService;

public class CreationMedicDtoServiceImpl implements CreationMedicDtoService {

	private JsonNodeService jsonService;
	private CreationFrequenceDtoService frequenceDtoService;
	private CreationDureeDtoService dureeDtoService;

	public CreationMedicDtoServiceImpl(JsonNodeService jsonService, CreationFrequenceDtoService frequenceDtoService,
			CreationDureeDtoService dureeDtoService) {
		this.jsonService = jsonService;
		this.frequenceDtoService = frequenceDtoService;
		this.dureeDtoService = dureeDtoService;
	}

	public CreationMedicDto createMedicDtoFromJsonNode(JsonNode jsonNode)
			throws JsonProcessingException, IllegalArgumentException {

		String nom = this.jsonService.getSingleValueFromJsonNode(jsonNode, "nom");
		Map<String, Object> mapDuree = this.jsonService.getMapFromJsonNodeWithKey(jsonNode, "dureeData");
		Map<String, Object> mapFreq = this.jsonService.getMapFromJsonNodeWithKey(jsonNode, "frequenceData");
		List<LocalTime> listeHeures = this.jsonService.getListFromJsonNodeWithKey(jsonNode, "listeHeures", "heure");

		return createMedicDtoFromMaps(nom, mapFreq, mapDuree, listeHeures);
	}

	/**
	 * La methode permets de construire un dto creationMedicDto a partir des
	 * elements en parametres.
	 * 
	 * @param nom         : String
	 * @param mapFreq     : Map<String, Object> : map contenant toutes les valeurs
	 *                    concernant la frequence. Cette map sera transformee en un
	 *                    objet FrequenceDto.
	 * @param mapDuree:   Map<String, Object> : map contenant toutes les valeurs
	 *                    concernant la duree. Cette map sera transformee en un
	 *                    objet DureeDto.
	 * @param listeHeures : List<LocalTime> : liste contenant les horaires de prise
	 *                    du medicaments.
	 * @return CreationMedicDto.
	 */
	private CreationMedicDto createMedicDtoFromMaps(String nom, Map<String, Object> mapFreq,
			Map<String, Object> mapDuree, List<LocalTime> listeHeures) {
		System.out.println("'''''''''createMedicDtoFromMaps''''");
		System.out.println("Map Duree =>" + mapDuree);
		System.out.println("Map Frequence =>" + mapFreq);

		CreationDureeDto dureeDto = this.dureeDtoService.createDureeDtoFromMap(mapDuree);
		CreationFrequenceDto frequenceDto = this.frequenceDtoService.createFrequenceFromMapDateFin(mapFreq, dureeDto,
				listeHeures);

		CreationMedicDto medicDto = new CreationMedicDto(nom, dureeDto, frequenceDto);

		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''");

		return medicDto;
	}

}
