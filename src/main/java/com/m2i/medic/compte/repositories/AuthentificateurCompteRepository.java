package com.m2i.medic.compte.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.compte.entities.Compte;


/**
 * Cette interface représente le repository authentificateur d'un compte
 * @author fabien
 *
 */
public interface AuthentificateurCompteRepository extends MongoRepository<Compte, String> {

	/**
	 * Cette méthode permet de vérifier si un compte existe à partir d'un pseudo ou un email
	 * @param email
	 * @param pseudo
	 * @return un compte
	 */
	public Optional<Compte> findFirstByEmail(String email);

}
