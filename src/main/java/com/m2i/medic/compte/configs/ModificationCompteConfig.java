package com.m2i.medic.compte.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.compte.repositories.ModificateurCompteRepository;
import com.m2i.medic.compte.services.implementations.ModificationCompteServiceImplementation;
import com.m2i.medic.compte.services.implementations.VerificationCompteServiceImplementation;

/**
 * Cette classe représente la configuration de la modification d'un compte
 * @author fabien
 *
 */
@Configuration
public class ModificationCompteConfig {
	
	/**
	 * Cette méthode permet de retourner un bean pour utiliser le service de chiffrement de mot de passe
	 * @return un bean
	 */
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}

	/**
	 * Cette méthode permet de retourner un bean pour utiliser le service de modification d'un compte
	 * @param mapper
	 * @param repository
	 * @param verificateur
	 * @return un bean
	 */
	@Bean
	public ModificationCompteServiceImplementation creerBeanModificationCompteServiceImplementation(ObjectMapper mapper, ModificateurCompteRepository repository, VerificationCompteServiceImplementation verificateur) {
		return new ModificationCompteServiceImplementation(mapper, repository, verificateur);
	}
	
	/**
	 * Cette méthode permet de retourner un bean pour utiliser le service de verification d'un compte
	 * @param mapper
	 * @param repository
	 * @return
	 */
	@Bean
	public VerificationCompteServiceImplementation creerBeanVerificationCompteServiceImplementation(ObjectMapper mapper, ModificateurCompteRepository repository) {
		return new VerificationCompteServiceImplementation(repository, mapper);
	}
}
