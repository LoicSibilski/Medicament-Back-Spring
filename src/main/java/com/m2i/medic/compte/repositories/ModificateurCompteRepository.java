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
	 * Cette méthode permet de récupérer une valeur vrai ou fausse, si un pseudo ou email existe
	 * @param emailOrPseudo
	 * @return vrai ou faux
	 */
	public Boolean findByEmailOrPseudo(String emailOrPseudo);
	
}
