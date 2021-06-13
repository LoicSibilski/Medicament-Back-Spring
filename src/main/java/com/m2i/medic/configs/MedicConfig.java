package com.m2i.medic.configs;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.implementations.medic.ModificationMedicServiceImpl;
import com.m2i.medic.services.implementations.medic.SimpleMedicDtoServiceImpl;
import com.m2i.medic.services.JsonNodeService;
import com.m2i.medic.services.duree.SimpleDureeDtoService;
import com.m2i.medic.services.frequence.SimpleFrequenceDtoService;
import com.m2i.medic.services.medic.ModificationMedicService;
import com.m2i.medic.services.medic.SimpleMedicDtoService;

@Configuration
public class MedicConfig {

	@Bean
	public SimpleMedicDtoService medicDtoServiceFactory(MedicRepository medicRepo, ObjectMapper mapper) {
		return new SimpleMedicDtoServiceImpl(medicRepo, mapper);
	}

	@Bean
	public ModificationMedicService modifDtoServiceFactory(MedicRepository medicRepo, ObjectMapper mapper,
			JsonNodeService jsonNodeService, SimpleFrequenceDtoService simpleFrequenceDtoService,
			SimpleDureeDtoService simpleDureeDtoService) {
		return new ModificationMedicServiceImpl(mapper, medicRepo, jsonNodeService, simpleFrequenceDtoService,
				simpleDureeDtoService);
	}

}
