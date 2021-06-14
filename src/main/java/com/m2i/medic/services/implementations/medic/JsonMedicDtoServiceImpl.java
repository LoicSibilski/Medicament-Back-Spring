package com.m2i.medic.services.implementations.medic;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.dtos.frequence.FrequenceDto;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.services.duree.JsonDureeDtoService;
import com.m2i.medic.services.frequence.JsonFrequenceDtoService;
import com.m2i.medic.services.json.JsonNodeService;
import com.m2i.medic.services.medic.JsonMedicDtoService;

public class JsonMedicDtoServiceImpl implements JsonMedicDtoService {

	private JsonNodeService jsonService;
	private JsonFrequenceDtoService jsonFrequenceDtoService;
	private JsonDureeDtoService jsonDureeDtoService;

	public JsonMedicDtoServiceImpl(JsonNodeService jsonService, JsonFrequenceDtoService jsonFrequenceDtoService,
			JsonDureeDtoService jsonDureeDtoService) {
		this.jsonService = jsonService;
		this.jsonFrequenceDtoService = jsonFrequenceDtoService;
		this.jsonDureeDtoService = jsonDureeDtoService;
	}

	public MedicDto createMedicDtoFromJsonNode(JsonNode jsonNode)
			throws JsonProcessingException, IllegalArgumentException {

		String nom = this.jsonService.getSingleValueFromJsonNode(jsonNode, "nom");
		nom = nom.substring(1, nom.length()-1);
		Map<String, Object> mapDuree = this.jsonService.getMapFromJsonNodeWithKey(jsonNode, "dureeData");
		Map<String, Object> mapFreq = this.jsonService.getMapFromJsonNodeWithKey(jsonNode, "frequenceData");
		List<LocalTime> listeHeures = this.jsonService.getListFromJsonNodeWithKey(jsonNode, "listeHeures", "heure");

		return createMedicDtoFromMaps(nom, mapFreq, mapDuree, listeHeures);
	}

	public MedicDto createMedicDtoFromMaps(String nom, Map<String, Object> mapFreq, Map<String, Object> mapDuree,
			List<LocalTime> listeHeures) {
		System.out.println("'''''''''createMedicDtoFromMaps''''");
		System.out.println("Map Duree =>" + mapDuree);
		System.out.println("Map Frequence =>" + mapFreq);

		DureeDto dureeDto = this.jsonDureeDtoService.createDureeDtoFromMap(mapDuree);

		FrequenceDto frequenceDto = this.jsonFrequenceDtoService.createFrequenceFromMapDateFin(mapFreq, dureeDto,
				listeHeures);

		MedicDto medicDto = new MedicDto();
		medicDto.setNom(nom);
		medicDto.setDureeDto(dureeDto);
		medicDto.setFrequenceDto(frequenceDto);
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''");

		return medicDto;
	}

}
