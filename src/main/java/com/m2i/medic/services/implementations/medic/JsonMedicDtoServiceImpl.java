package com.m2i.medic.services.implementations.medic;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.m2i.medic.dtos.duree.SimpleDureeDto;
import com.m2i.medic.dtos.frequence.SimpleFrequenceDto;
import com.m2i.medic.dtos.medic.SimpleMedicDto;
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

	public SimpleMedicDto createMedicDtoFromJsonNode(JsonNode jsonNode)
			throws JsonProcessingException, IllegalArgumentException {

		String nom = this.jsonService.getSingleValueFromJsonNode(jsonNode, "nom");
		Map<String, Object> mapDuree = this.jsonService.getMapFromJsonNodeWithKey(jsonNode, "dureeData");
		Map<String, Object> mapFreq = this.jsonService.getMapFromJsonNodeWithKey(jsonNode, "frequenceData");
		List<LocalTime> listeHeures = this.jsonService.getListFromJsonNodeWithKey(jsonNode, "listeHeures", "heure");

		return createMedicDtoFromMaps(nom, mapFreq, mapDuree, listeHeures);
	}

	public SimpleMedicDto createMedicDtoFromMaps(String nom, Map<String, Object> mapFreq, Map<String, Object> mapDuree,
			List<LocalTime> listeHeures) {
		System.out.println("'''''''''createMedicDtoFromMaps''''");
		System.out.println("Map Duree =>" + mapDuree);
		System.out.println("Map Frequence =>" + mapFreq);

		SimpleDureeDto dureeDto = this.jsonDureeDtoService.createDureeDtoFromMap(mapDuree);

		SimpleFrequenceDto frequenceDto = this.jsonFrequenceDtoService.createFrequenceFromMapDateFin(mapFreq, dureeDto,
				listeHeures);

		SimpleMedicDto medicDto = new SimpleMedicDto(nom, dureeDto, frequenceDto);

		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''");

		return medicDto;
	}

}
