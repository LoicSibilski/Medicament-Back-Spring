package com.m2i.medic.services.implementations.frequence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.frequence.FrequenceDto;
import com.m2i.medic.models.Frequence;
import com.m2i.medic.repositories.FrequenceRepository;
import com.m2i.medic.services.frequence.ModificationFrequenceDtoService;

public class ModificationFrequenceDtoServiceImpl implements ModificationFrequenceDtoService {

	private FrequenceRepository frequenceRepository;
	private ObjectMapper mapper;

	public ModificationFrequenceDtoServiceImpl(FrequenceRepository medicRepo, ObjectMapper mapper) {
		this.frequenceRepository = medicRepo;
		this.mapper = mapper;
	}

	@Override
	public FrequenceDto save(FrequenceDto dto) {
		Frequence entity = mapper.convertValue(dto, Frequence.class);
		Frequence result = this.frequenceRepository.save(entity);
		return this.mapper.convertValue(result, FrequenceDto.class);
	}

	@Override
	public FrequenceDto updateById(FrequenceDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
