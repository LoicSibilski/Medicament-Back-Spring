package com.m2i.medic.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.duree.CreationDureeDtoService;
import com.m2i.medic.services.frequence.CreationFrequenceDtoService;
import com.m2i.medic.services.implementations.medic.CreationMedicDtoServiceImpl;
import com.m2i.medic.services.implementations.medic.ModificationMedicServiceImpl;
import com.m2i.medic.services.implementations.medic.SimpleMedicDtoServiceImpl;
import com.m2i.medic.services.medic.CreationMedicDtoService;

@Configuration
public class MedicConfig {

	@Bean 
	public CreationMedicDtoServiceImpl creationMedicDtoServiceFactory(CreationDureeDtoService creationDureeDtoService,
			CreationFrequenceDtoService creationFrequenceDtoService) {
		return new CreationMedicDtoServiceImpl(creationDureeDtoService, creationFrequenceDtoService);
	}
	
	@Bean
	public ModificationMedicServiceImpl modifMedicDtoServiceFactory(ObjectMapper mapper, MedicRepository medicRepository,
			CreationMedicDtoService creationMedicService) {
		return new ModificationMedicServiceImpl(mapper, medicRepository, creationMedicService);
	}

	@Bean
	public SimpleMedicDtoServiceImpl simpleMedicDtoServiceFactory(ObjectMapper mapper, MedicRepository medicRepo) {
		return new SimpleMedicDtoServiceImpl(medicRepo, mapper);
	}

}
