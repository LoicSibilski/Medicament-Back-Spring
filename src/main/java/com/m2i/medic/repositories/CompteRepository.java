package com.m2i.medic.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.models.Compte;

/**
 * Cette classe représente le repository d'un compte
 * @author fabien
 *
 */
public interface CompteRepository extends MongoRepository<Compte, String> {

}
