package com.m2i.medic.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.repositories.FrequenceRepository;
import com.m2i.medic.services.frequence.ModificationFrequenceDtoService;
import com.m2i.medic.services.implementations.frequence.CreationFrequenceDtoServiceImpl;
import com.m2i.medic.services.implementations.frequence.ModificationFrequenceDtoServiceImpl;
import com.m2i.medic.services.implementations.frequence.SimpleFrequenceDtoServiceImpl;

@Configuration
public class FrequenceConfig {

	@Bean
	public CreationFrequenceDtoServiceImpl creationFrequenceDtoServiceFactory(ObjectMapper mapper,
			ModificationFrequenceDtoService modifFrequenceService) {
		return new CreationFrequenceDtoServiceImpl(mapper, modifFrequenceService);
	}

	@Bean
	public ModificationFrequenceDtoServiceImpl modifFrequenceDtoServiceFactory(FrequenceRepository frequenceRepo,
			ObjectMapper mapper) {
		return new ModificationFrequenceDtoServiceImpl(frequenceRepo, mapper);
	}

	@Bean
	public SimpleFrequenceDtoServiceImpl simpleFrequenceDtoServiceFactory(FrequenceRepository frequenceRepo,
			ObjectMapper mapper) {
		return new SimpleFrequenceDtoServiceImpl(frequenceRepo, mapper);
	}
}
