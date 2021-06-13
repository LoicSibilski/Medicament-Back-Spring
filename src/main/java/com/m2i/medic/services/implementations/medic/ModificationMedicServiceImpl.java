package com.m2i.medic.services.implementations.medic;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.models.Duree;
import com.m2i.medic.models.Frequence;
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
	public MedicDto save(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException {
		MedicDto medicDto = this.jsonMedicDtoService.createMedicDtoFromJsonNode(jsonNode);
		System.out.println("creationMedicDto => " + medicDto);
		Medic entity = this.convertMedicFromDto(medicDto);
		System.out.println("entity >>>> " + entity);
		Medic result = this.medicRepository.save(entity);
		System.out.println("result =>> "+ result);
		return this.mapper.convertValue(result, MedicDto.class);
	}

	@Override
	public MedicDto update(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Medic convertMedicFromDto(MedicDto dto) {
		Medic med = new Medic();
		med.setNom(dto.getNom());
		med.setDuree(this.mapper.convertValue(dto.getDureeDto(), Duree.class));
		med.setFrequence(this.mapper.convertValue(dto.getFrequenceDto(), Frequence.class));
		return med;
	}

}
