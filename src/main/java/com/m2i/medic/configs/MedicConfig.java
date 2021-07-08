package com.m2i.medic.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.duree.CreationDureeDtoService;
import com.m2i.medic.services.frequence.CreationFrequenceDtoService;
import com.m2i.medic.services.implementations.medic.CreationMedicDtoServiceImpl;
import com.m2i.medic.services.implementations.medic.ModificationMedicServiceImpl;
import com.m2i.medic.services.infoMedic.ModificationInfoMedicService;
import com.m2i.medic.services.implementations.medic.MedicDtoServiceImpl;
import com.m2i.medic.services.medic.CreationMedicDtoService;

@Configuration
public class MedicConfig {

	@Bean
	public CreationMedicDtoServiceImpl creationMedicDtoServiceFactory(CreationDureeDtoService creationDureeDtoService,
			CreationFrequenceDtoService creationFrequenceDtoService,
			ModificationInfoMedicService modificationInfoMedicService) {
		return new CreationMedicDtoServiceImpl(creationDureeDtoService, creationFrequenceDtoService,
				modificationInfoMedicService);
	}

	@Bean
	public ModificationMedicServiceImpl modifMedicDtoServiceFactory(ObjectMapper mapper,
			MedicRepository medicRepository, CreationMedicDtoService creationMedicService) {
		return new ModificationMedicServiceImpl(mapper, medicRepository, creationMedicService);
	}

	@Bean
	public MedicDtoServiceImpl simpleMedicDtoServiceFactory(ObjectMapper mapper, MedicRepository medicRepo) {
		return new MedicDtoServiceImpl(medicRepo, mapper);
	}

}
