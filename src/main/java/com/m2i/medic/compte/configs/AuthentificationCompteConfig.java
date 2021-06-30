package com.m2i.medic.compte.configs;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.compte.repositories.AuthentificateurCompteRepository;
import com.m2i.medic.compte.services.AuthentificateurCompteService;
import com.m2i.medic.compte.services.impl.AuthentificationCompteServiceImpl;

/**
 * Cette classe représente la configuration de l'authentificaiton d'un compte
 * @author fabien
 *
 */
public class AuthentificationCompteConfig {

	/**
	 * Cette méthode permet de retourner un objet pour utiliser le service d'authentification d'un compte
	 * @param repository
	 * @param mapper
	 * @return un service
	 */
	@Bean
	public AuthentificateurCompteService creerBeanAuthentificationCompteServiceImpl(ObjectMapper mapper, AuthentificateurCompteRepository repository) {
		return new AuthentificationCompteServiceImpl(mapper, repository);
	}
	
}
