package com.m2i.medic.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.models.Utilisateur;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String>{

	public List<Utilisateur> findAllByCompteId(String id);
	
	public List<Utilisateur> findAllByAssistantsId(String id);
}
