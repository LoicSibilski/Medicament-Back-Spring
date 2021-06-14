package com.m2i.medic.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.repositories.FrequenceRepository;
import com.m2i.medic.services.frequence.ModificationFrequenceDtoService;
import com.m2i.medic.services.implementations.frequence.JsonFrequenceDtoServiceImpl;
import com.m2i.medic.services.implementations.frequence.ModificationFrequenceDtoServiceImpl;
import com.m2i.medic.services.implementations.frequence.SimpleFrequenceDtoServiceImpl;

@Configuration
public class FrequenceConfig {
	
	@Bean
	public JsonFrequenceDtoServiceImpl jsonFrequenceDtoServiceFactory(ModificationFrequenceDtoService modifFreqServ,
			ObjectMapper mapper) {
		return new JsonFrequenceDtoServiceImpl(modifFreqServ, mapper);
	}
	
	@Bean
	public ModificationFrequenceDtoServiceImpl modifFrequenceDtoServiceFactory(FrequenceRepository frequenceRepo,
			ObjectMapper mapper){
		return new ModificationFrequenceDtoServiceImpl(frequenceRepo, mapper);
	}
	
	@Bean
	public SimpleFrequenceDtoServiceImpl simpleFrequenceDtoServiceFactory(FrequenceRepository frequenceRepo,
			ObjectMapper mapper){
		return new SimpleFrequenceDtoServiceImpl(frequenceRepo, mapper);
	}
}
