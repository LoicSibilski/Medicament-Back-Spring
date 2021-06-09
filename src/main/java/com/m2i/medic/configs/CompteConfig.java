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
import com.m2i.medic.services.CompteService;
import com.m2i.medic.services.implementations.CompteServiceImpl;

/**
 * Cette classe représente une configuration de compte
 * @author fabien
 *
 */
@Configuration
public class CompteConfig {
	
	/**
	 * Cette méthode permet de retourner un objet pour le service d'un compte
	 * @param repository
	 * @param mapper
	 * @return un objet utile à l'implémentation des services d'un compte
	 */
	@Bean
	public CompteService compteService(CompteRepository repository, ObjectMapper mapper) {
		return new CompteServiceImpl(repository, mapper);
	}

	/**
	 * Cette méthode permet de retourner un objet pour faire la correspondance avec un modèle
	 * @return objet mapper utile pour convertir un objet en entrée avec un modèle
	 */
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().registerModule(new JavaTimeModule())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).setVisibility(
						VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

	}
}
