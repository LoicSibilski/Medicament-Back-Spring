package com.m2i.medic.services.implementations.infoMedic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.infoMedic.InfoMedicDto;
import com.m2i.medic.dtos.infoMedic.ModificationInfoMedicDto;
import com.m2i.medic.models.InfoMedic;
import com.m2i.medic.repositories.InfoMedicRepository;
import com.m2i.medic.services.infoMedic.InfoMedicDtoService;
import com.m2i.medic.services.infoMedic.ModificationInfoMedicService;

public class ModificationInfoMedicServiceImpl implements ModificationInfoMedicService {

	private ObjectMapper mapper;
	private InfoMedicRepository infoRepo;
	private InfoMedicDtoService infoMedicService;

	public ModificationInfoMedicServiceImpl(ObjectMapper mapper, InfoMedicRepository infoRepo,
			InfoMedicDtoService infoMedicService) {
		this.mapper = mapper;
		this.infoRepo = infoRepo;
		this.infoMedicService = infoMedicService;
	}

	@Override
	public InfoMedicDto save(ModificationInfoMedicDto modificationInfoMedicDto) {
		InfoMedic entity = mapper.convertValue(modificationInfoMedicDto, InfoMedic.class);
		InfoMedic resul = infoRepo.save(entity);
		return this.mapper.convertValue(resul, InfoMedicDto.class);
	}

	@Override
	public InfoMedicDto update(InfoMedicDto infoMedicDto) {
		InfoMedicDto infoMedic = this.infoMedicService.getById(infoMedicDto.getId());
		ModificationInfoMedicDto modif = new ModificationInfoMedicDto(infoMedic);
		
		return infoMedicDto;

	}

}
