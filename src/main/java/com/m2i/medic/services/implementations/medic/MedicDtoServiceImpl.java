package com.m2i.medic.services.implementations.medic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.medic.SimpleMedicDto;
import com.m2i.medic.dtos.medic.MedicDto;
import com.m2i.medic.models.Medic;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.medic.SimpleMedicDtoService;
import com.m2i.medic.services.medic.MedicDtoService;

import java.util.List;
import java.util.stream.Collectors;

public class MedicDtoServiceImpl implements MedicDtoService {

	private MedicRepository medicRepository;
	private SimpleMedicDtoService medicDtoService;
	private ObjectMapper mapper;

	public MedicDtoServiceImpl(MedicRepository medicRepo, SimpleMedicDtoService medicDtoService,
			ObjectMapper mapper) {
		this.medicRepository = medicRepo;
		this.medicDtoService = medicDtoService;
		this.mapper = mapper;
	}

	public List<MedicDto> getAll() {
		List<Medic> medics = this.medicRepository.findAll();
		
		
		return medics.stream().map(medic->{
			return this.mapper.convertValue(medic, MedicDto.class);
		}).collect(Collectors.toList());
	}

	public MedicDto getById(String id) {
		Medic medic = this.medicRepository.findById(id).get();
		return mapper.convertValue(medic, MedicDto.class);
	}

	public SimpleMedicDto save(JsonNode jsonNode) throws JsonProcessingException, IllegalArgumentException {
		SimpleMedicDto creationMedicDto = this.medicDtoService.createMedicDtoFromJsonNode(jsonNode);
		Medic entity = this.mapper.convertValue(creationMedicDto, Medic.class);
		Medic result = this.medicRepository.save(entity);
		return this.mapper.convertValue(result, SimpleMedicDto.class);
	}
	
	@Override
	public MedicDto updateById(MedicDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteByID(String id) {
		System.out.println("HERETIQUE AU BUCHER " + getById(id).toString());
		this.medicRepository.deleteById(id);
		;
	}

	public void deleteAll() {
		List<Medic> liste = this.medicRepository.findAll();
		for (Medic medic : liste) {
			this.medicRepository.delete(medic);
		}
		// TODO Auto-generated method stub
	}



}
