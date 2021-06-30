package com.m2i.medic.configs.compte.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.configs.compte.entities.Compte;


/**
 * Cette classe représente le repository d'un compte
 * @author fabien
 *
 */
public interface AuthentificateurCompteRepository extends MongoRepository<Compte, String> {

	/**
	 * Cette méthode permet de récupérer un compte à partir d'un pseudo ou un email
	 * @param email
	 * @param pseudo
	 * @return un compte
	 */
	public Compte findFirstByPseudoOrEmail(String email, String pseudo);

}
