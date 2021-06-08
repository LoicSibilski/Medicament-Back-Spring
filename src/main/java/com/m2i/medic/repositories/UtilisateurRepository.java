package com.m2i.medic.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.models.Utilisateur;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String>{

}
