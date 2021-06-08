package com.m2i.medic.services;

import java.util.List;

import com.m2i.medic.dtos.AssistantOuAssisteDTO;
import com.m2i.medic.models.Utilisateur;

public interface UtilisateurService extends GenericService<Utilisateur>{
	
	public List<Utilisateur> findAllByCompteId(String id);
	
	public List<AssistantOuAssisteDTO> findAllAssistantsByCompteId(String id);
	
	public List<AssistantOuAssisteDTO> findAllAssistesByCompteId(String id);

}
