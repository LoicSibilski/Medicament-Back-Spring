package com.m2i.medic.compte.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.compte.repositories.ModificateurCompteRepository;
import com.m2i.medic.compte.services.implementations.ModificationCompteServiceImplementation;

/**
 * Cette classe représente la configuration de la modification d'un compte
 * @author fabien
 *
 */
@Configuration
public class ModificationCompteConfig {

	/**
	 * Cette méthode permet de retourner un bean pour utiliser le service de modification d'un compte
	 * @param mapper
	 * @param repository
	 * @return un bean
	 */
	@Bean
	public ModificationCompteServiceImplementation creerBeanModificationCompteServiceImplementation(ObjectMapper mapper, ModificateurCompteRepository repository) {
		return new ModificationCompteServiceImplementation(mapper, repository);
	}
}
