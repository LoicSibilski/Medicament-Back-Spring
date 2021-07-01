package com.m2i.medic.compte.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.compte.entities.Compte;

/**
 * Cette interface représente le repository modificateur d'un compte
 * @author fabien
 *
 */
public interface ModificateurCompteRepository extends MongoRepository<Compte, String> {

	/**
	 * Cette méthode permet de récupérer une valeur vrai ou fausse, si l'email de l'utilisateur existe
	 * @param email
	 * @return vrai ou faux
	 */
	public boolean findByEmail(String email);
	
	/**
	 * Cette méthode permet de récupérer une valeur vrai ou fausse, si le pseudo de l'utilisateur existe
	 * @param pseudo
	 * @return vrai ou faux
	 */
	public boolean findByPseudo(String pseudo);
}
