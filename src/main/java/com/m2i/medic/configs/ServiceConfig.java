package com.m2i.medic.configs;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.m2i.medic.models.Duree;
import com.m2i.medic.models.Frequence;
import com.m2i.medic.services.GenericService;
import com.m2i.medic.services.MedicService;
import com.m2i.medic.services.UtilisateurService;
import com.m2i.medic.services.implementations.DureeServiceImpl;
import com.m2i.medic.services.implementations.FrequenceServiceImpl;
import com.m2i.medic.services.implementations.MedicServiceImpl;
import com.m2i.medic.services.implementations.UtilisateurServiceImpl;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class ServiceConfig {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().registerModule(new JavaTimeModule())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).setVisibility(
						VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

	}

	@Bean
	public DateTimeFormatter dateFormatter() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return dateFormatter;
	}
	
	@Bean 
	public UtilisateurService utilisateurServiceFactory() {
		return new UtilisateurServiceImpl();
	}
}
