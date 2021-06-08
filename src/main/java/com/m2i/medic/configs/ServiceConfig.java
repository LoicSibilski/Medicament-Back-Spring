package com.m2i.medic.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.m2i.medic.models.Duree;
import com.m2i.medic.models.Frequence;
import com.m2i.medic.repositories.MedicRepository;
import com.m2i.medic.services.GenericService;
import com.m2i.medic.services.MedicService;
import com.m2i.medic.services.implementations.DureeServiceImpl;
import com.m2i.medic.services.implementations.FrequenceServiceImpl;
import com.m2i.medic.services.implementations.MedicServiceImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public MedicService medicServiceFactory(MedicRepository medicRepo, ObjectMapper mapper) {
		return new MedicServiceImpl(medicRepo, mapper);
	}
	
	@Bean
	public GenericService<Duree> dureeServiceFactory() {
		return new DureeServiceImpl();
	}
	
	@Bean
	public GenericService<Frequence> frequenceServiceFactory() {
		return new FrequenceServiceImpl();
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		
	}
}
