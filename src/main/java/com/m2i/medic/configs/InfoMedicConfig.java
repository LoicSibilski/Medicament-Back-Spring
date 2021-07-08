package com.m2i.medic.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.repositories.InfoMedicRepository;
import com.m2i.medic.services.implementations.infoMedic.InfoMedicServiceImpl;
import com.m2i.medic.services.implementations.infoMedic.ModificationInfoMedicServiceImpl;
import com.m2i.medic.services.infoMedic.InfoMedicDtoService;

@Configuration
public class InfoMedicConfig {

	@Bean
	public InfoMedicServiceImpl infoMedicDtoServiceFactory(InfoMedicRepository infoMedicRepository,
			ObjectMapper mapper) {
		return new InfoMedicServiceImpl(infoMedicRepository, mapper);
	}

	@Bean
	public ModificationInfoMedicServiceImpl modifInfoMedicDtoServiceFactory(ObjectMapper mapper,
			InfoMedicRepository infoRepo, InfoMedicDtoService infoMedicService) {
		return new ModificationInfoMedicServiceImpl(mapper, infoRepo, infoMedicService);
	}

}
