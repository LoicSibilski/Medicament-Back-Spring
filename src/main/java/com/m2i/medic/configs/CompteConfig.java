package com.m2i.medic.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.m2i.medic.repositories.CompteRepository;
import com.m2i.medic.services.AuthentificationService;
import com.m2i.medic.services.CompteService;
import com.m2i.medic.services.implementations.AuthentificationServiceImpl;
import com.m2i.medic.services.implementations.CompteServiceImpl;

/**
 * Cette classe représente une configuration de compte
 * @author fabien
 *
 */
@Configuration
public class CompteConfig {
	
	@Bean
	public CompteService compteService(CompteRepository repository, ObjectMapper mapper) {
		return new CompteServiceImpl(repository, mapper);
	}
	
	@Bean
	public AuthentificationService authentificationService(CompteRepository repository, ObjectMapper mapper) {
		return new AuthentificationServiceImpl(repository, mapper);
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().registerModule(new JavaTimeModule())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).setVisibility(
						VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

	}
}
