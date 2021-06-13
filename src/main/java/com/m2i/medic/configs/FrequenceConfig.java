package com.m2i.medic.configs;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.repositories.FrequenceRepository;
import com.m2i.medic.services.duree.ModificationDureeService;
import com.m2i.medic.services.implementations.frequence.JsonFrequenceDtoServiceImpl;
import com.m2i.medic.services.implementations.frequence.ModificationFrequenceDtoServiceImpl;
import com.m2i.medic.services.implementations.frequence.SimpleFrequenceDtoServiceImpl;

@Configuration
public class FrequenceConfig {
	
	@Bean
	public JsonFrequenceDtoServiceImpl jsonFrequenceDtoServiceFactory(DateTimeFormatter dateTimeFormatter,
			ModificationDureeService modifDureeService) {
		return new JsonFrequenceDtoServiceImpl();
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
