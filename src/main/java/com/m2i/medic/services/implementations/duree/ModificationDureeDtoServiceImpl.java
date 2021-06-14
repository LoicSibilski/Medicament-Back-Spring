package com.m2i.medic.services.implementations.duree;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.duree.DureeDto;
import com.m2i.medic.models.Duree;
import com.m2i.medic.repositories.DureeRepository;
import com.m2i.medic.services.duree.ModificationDureeService;

public class ModificationDureeDtoServiceImpl implements ModificationDureeService {

	private ObjectMapper mapper;
	private DureeRepository dureeRepo;

	public ModificationDureeDtoServiceImpl(DureeRepository dureeRepo, ObjectMapper mapper) {
		this.dureeRepo = dureeRepo;
		this.mapper = mapper;
	}

	@Override
	public DureeDto save(DureeDto dto) {
		Duree entity = mapper.convertValue(dto, Duree.class);
		Duree result = this.dureeRepo.save(entity);
		return this.mapper.convertValue(result, DureeDto.class);
	}

	@Override
	public DureeDto updateById(DureeDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
