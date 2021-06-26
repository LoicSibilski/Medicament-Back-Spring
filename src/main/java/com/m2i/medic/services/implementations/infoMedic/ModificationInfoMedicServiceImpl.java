package com.m2i.medic.services.implementations.infoMedic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.infoMedic.InfoMedicDto;
import com.m2i.medic.dtos.infoMedic.ModificationInfoMedicDto;
import com.m2i.medic.repositories.InfoMedicRepository;
import com.m2i.medic.services.infoMedic.ModificationInfoMedicService;

public class ModificationInfoMedicServiceImpl implements ModificationInfoMedicService{
	
	private ObjectMapper mapper;
	private InfoMedicRepository infoRepo;
	
	public ModificationInfoMedicServiceImpl(ObjectMapper mapper, InfoMedicRepository infoRepo) {
		super();
		this.mapper = mapper;
		this.infoRepo = infoRepo;
	}

	@Override
	public InfoMedicDto save(ModificationInfoMedicDto modificationInfoMedicDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoMedicDto update(ModificationInfoMedicDto modificationInfoMedicDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
