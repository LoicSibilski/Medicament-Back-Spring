package com.m2i.medic.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.models.Compte;

/**
 * Cette classe représente le repository d'un compte
 * @author fabien
 *
 */
public interface CompteRepository extends MongoRepository<Compte, String> {

	/**
	 * Cette méthode permet de récupérer un compte à partir d'une adresse email
	 * @param une adresse email
	 * @return un compte
	 */
	public CompteDTO findByEmail(String email);
	
}
