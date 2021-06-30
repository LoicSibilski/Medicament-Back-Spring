package com.m2i.medic.services;

import java.util.List;

import com.m2i.medic.dtos.AssistantOuAssisteDTO;
import com.m2i.medic.models.Utilisateur;
import com.m2i.medic.services.generic.GenericModificationCRUDService;
import com.m2i.medic.services.generic.GenericSimpleCRUDService;

public interface UtilisateurService extends GenericSimpleCRUDService<Utilisateur>, GenericModificationCRUDService<Utilisateur>{
	
	public List<Utilisateur> findAllByCompteId(String id);
	
	public List<AssistantOuAssisteDTO> findAllAssistantsByCompteId(String id);

	public List<AssistantOuAssisteDTO> findAllAssistesByUtilisateurId(String id);
	
	public List<AssistantOuAssisteDTO> findAllAssistesByCompteId(String id);
}
