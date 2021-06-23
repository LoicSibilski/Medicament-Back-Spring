package com.m2i.medic.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.dtos.AssistantOuAssisteDTO;
import com.m2i.medic.models.Utilisateur;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String>{

	public List<Utilisateur> findAllByCompteId(String id);
	
	public List<AssistantOuAssisteDTO> findAllAssistantsByCompteId(String id);
	
	public List<AssistantOuAssisteDTO> findAllByAssistantOuAssisteDTOId(String id);
}
