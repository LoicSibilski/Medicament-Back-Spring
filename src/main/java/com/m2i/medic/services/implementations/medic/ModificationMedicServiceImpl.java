package com.m2i.medic.services.implementations.medic;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.medic.SimpleMedicDto;
import com.m2i.medic.models.Medic;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.medic.JsonMedicDtoService;
import com.m2i.medic.services.medic.ModificationMedicService;

public class ModificationMedicServiceImpl implements ModificationMedicService {

	private ObjectMapper mapper;
	private MedicRepository medicRepository;
	private JsonMedicDtoService jsonMedicDtoService;

	public ModificationMedicServiceImpl(ObjectMapper mapper, MedicRepository medicRepository,
			JsonMedicDtoService jsonMedicDtoService) {
		this.mapper = mapper;
		this.medicRepository = medicRepository;
		this.jsonMedicDtoService = jsonMedicDtoService;
	}

	@Override
	public SimpleMedicDto save(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException {
		SimpleMedicDto creationMedicDto = this.jsonMedicDtoService.createMedicDtoFromJsonNode(jsonNode);
		
		Medic entity = this.mapper.convertValue(creationMedicDto, Medic.class);
		Medic result = this.medicRepository.save(entity);
		return this.mapper.convertValue(result, SimpleMedicDto.class);
	}

	@Override
	public SimpleMedicDto update(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
