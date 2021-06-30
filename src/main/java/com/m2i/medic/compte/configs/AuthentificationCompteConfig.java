package com.m2i.medic.compte.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.compte.repositories.AuthentificateurCompteRepository;
import com.m2i.medic.compte.services.AuthentificateurCompteService;
import com.m2i.medic.compte.services.implementations.AuthentificationCompteServiceImplementation;

/**
 * Cette classe représente la configuration de l'authentificaiton d'un compte
 * @author fabien
 *
 */
@Configuration
public class AuthentificationCompteConfig {

	/**
	 * Cette méthode permet de retourner un bean pour utiliser le service d'authentification d'un compte
	 * @param repository
	 * @param mapper
	 * @return un bean
	 */
	@Bean
	public AuthentificateurCompteService creerBeanAuthentificationCompteServiceImplementation(ObjectMapper mapper, AuthentificateurCompteRepository repository) {
		return new AuthentificationCompteServiceImplementation(mapper, repository);
	}
	
}
