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
import com.m2i.medic.services.ModificateurCompteService;
import com.m2i.medic.services.implementations.AuthentificationServiceImpl;
import com.m2i.medic.services.implementations.CompteServiceImpl;
import com.m2i.medic.services.implementations.ModificateurCompteServiceImpl;

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
	
	@Bean
	public AuthentificationService authentificationService(CompteRepository repository, ObjectMapper mapper) {
		return new AuthentificationServiceImpl(repository, mapper);
	}
	
	@Bean
	public ModificateurCompteService modificateurCompteService(CompteRepository repository, ObjectMapper mapper) {
		return new ModificateurCompteServiceImpl(repository, mapper);
	}

}
