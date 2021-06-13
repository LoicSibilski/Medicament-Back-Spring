package com.m2i.medic.services.implementations.medic;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.duree.SimpleDureeDto;
import com.m2i.medic.dtos.frequence.SimpleFrequenceDto;
import com.m2i.medic.dtos.medic.SimpleMedicDto;
import com.m2i.medic.models.Medic;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.JsonNodeService;
import com.m2i.medic.services.duree.SimpleDureeDtoService;
import com.m2i.medic.services.frequence.SimpleFrequenceDtoService;
import com.m2i.medic.services.medic.ModificationMedicService;

public class ModificationMedicServiceImpl implements ModificationMedicService {

	private ObjectMapper mapper;
	private MedicRepository medicRepository;
	
	private JsonNodeService jsonService;
	private SimpleFrequenceDtoService frequenceDtoService;
	private SimpleDureeDtoService dureeDtoService;

	public ModificationMedicServiceImpl(ObjectMapper mapper,MedicRepository medicRepository, JsonNodeService jsonService,
			SimpleFrequenceDtoService frequenceDtoService, SimpleDureeDtoService dureeDtoService) {
		this.mapper = mapper;
		this.medicRepository = medicRepository;
		this.jsonService = jsonService;
		this.frequenceDtoService = frequenceDtoService;
		this.dureeDtoService = dureeDtoService;
	}

	public SimpleMedicDto save(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException {
		SimpleMedicDto creationMedicDto = this.createMedicDtoFromJsonNode(jsonNode);
		Medic entity = this.mapper.convertValue(creationMedicDto, Medic.class);
		Medic result = this.medicRepository.save(entity);
		return this.mapper.convertValue(result, SimpleMedicDto.class);
	}

	@Override
	public SimpleMedicDto update(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * La methode permets de construire un dto creationMedicDto a partir du JSON
	 * envoye par l'utilisateur depuis le front.
	 * 
	 * @param jsonNode : JSON contenant toutes les informations et toutes les
	 *                 options possible.
	 * @return CreationMedicDto.
	 */
	private SimpleMedicDto createMedicDtoFromJsonNode(JsonNode jsonNode)
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
	 * @param mapDuree    : Map<String, Object> : map contenant toutes les valeurs
	 *                    concernant la duree. Cette map sera transformee en un
	 *                    objet DureeDto.
	 * @param listeHeures : List<LocalTime> : liste contenant les horaires de prise
	 *                    du medicaments.
	 * @return CreationMedicDto.
	 */
	private SimpleMedicDto createMedicDtoFromMaps(String nom, Map<String, Object> mapFreq, Map<String, Object> mapDuree,
			List<LocalTime> listeHeures) {
		System.out.println("'''''''''createMedicDtoFromMaps''''");
		System.out.println("Map Duree =>" + mapDuree);
		System.out.println("Map Frequence =>" + mapFreq);

		SimpleDureeDto dureeDto = this.dureeDtoService.createDureeDtoFromMap(mapDuree);
		SimpleFrequenceDto frequenceDto = this.frequenceDtoService.createFrequenceFromMapDateFin(mapFreq, dureeDto,
				listeHeures);

		SimpleMedicDto medicDto = new SimpleMedicDto(nom, dureeDto, frequenceDto);

		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''");

		return medicDto;
	}

}
