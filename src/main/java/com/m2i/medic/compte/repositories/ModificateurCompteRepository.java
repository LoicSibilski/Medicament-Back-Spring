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
	 * Cette méthode permet de vérifier si l'email de l'utilisateur existe
	 * @param email
	 * @return une chaîne de caractères
	 */
	public String findByEmail(String email);
	
	/**
	 * Cette méthode permet de vérifier si le pseudo de l'utilisateur existe
	 * @param pseudo
	 * @return une chaîne de caractères
	 */
	public String findByPseudo(String pseudo);
}
