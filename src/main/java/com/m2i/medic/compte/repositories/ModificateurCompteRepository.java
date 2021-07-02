package com.m2i.medic.compte.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.compte.dtos.InscriptionDTO;
import com.m2i.medic.compte.entities.Compte;

/**
 * Cette interface représente le repository modificateur d'un compte
 * @author fabien
 *
 */
public interface ModificateurCompteRepository extends MongoRepository<Compte, String> {

	/**
	 * Cette méthode permet de récupérer une liste d'email si l'email de l'utilisateur existe
	 * @param email
	 * @return vrai ou faux
	 */
	public String findByEmail(String email);
	
	/**
	 * Cette méthode permet de récupérer une valeur vrai ou fausse, si le pseudo de l'utilisateur existe
	 * @param pseudo
	 * @return vrai ou faux
	 */
	public String findByPseudo(String pseudo);
}
