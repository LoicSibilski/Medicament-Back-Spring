package com.m2i.medic.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2i.medic.dtos.AssistantOuAssisteDTO;
import com.m2i.medic.models.Utilisateur;
import com.m2i.medic.repositories.UtilisateurRepository;
import com.m2i.medic.services.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService{

	@Autowired
	private UtilisateurRepository repository;
	
	@Override
	public List<Utilisateur> getAll() {
		return this.repository.findAll();
	}

	@Override
	public Utilisateur getById(String id) {
		return this.repository.findById(id).get();
	}

	@Override
	public Utilisateur save(Utilisateur entity) {
		return this.repository.save(entity);
	}

	@Override
	public Utilisateur updateById(Utilisateur entity) {
		return this.repository.save(entity);
	}

	@Override
	public void deleteByID(String id) {
		this.repository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		this.repository.deleteAll();
	}

	@Override
	public List<Utilisateur> findAllByCompteId(String id) {
		return this.repository.findAllByCompteId(id);
	}

	@Override
	public List<AssistantOuAssisteDTO> findAllAssistantsByCompteId(String id) {
		List<Utilisateur> utilisateurs = this.repository.findAllByCompteId(id);
		List<AssistantOuAssisteDTO> assistants = new ArrayList<>();
		for (Utilisateur utilisateur : utilisateurs) {
			List<AssistantOuAssisteDTO> assistantsUtilisateur = utilisateur.getAssistants();
			for (AssistantOuAssisteDTO assistantUtilisateur : assistantsUtilisateur) {
				assistants.add(assistantUtilisateur);
			}	
		}
		return assistants;
	}

	@Override
	public List<AssistantOuAssisteDTO> findAllAssistesByUtilisateurId(String id) {
		List<Utilisateur> liste = this.repository.findAllByAssistantsId(id);
		List<AssistantOuAssisteDTO> assistes = new ArrayList<>();
		for (Utilisateur utilisateur : liste) {
			AssistantOuAssisteDTO assiste = new AssistantOuAssisteDTO(utilisateur.getId(), utilisateur.getNom(), utilisateur.getPrenom());
			assistes.add(assiste);
			}
		return assistes;
	}

	@Override
	public List<AssistantOuAssisteDTO> findAllAssistesByCompteId(String id) {
		List<Utilisateur> utilisateurs = this.findAllByCompteId(id);
		List<AssistantOuAssisteDTO> assistesDuCompte = new ArrayList<>();
		for (Utilisateur utilisateur : utilisateurs) {
			List<AssistantOuAssisteDTO> assistesDeLUtilisateur = this.findAllAssistesByUtilisateurId(utilisateur.getId());
			for (AssistantOuAssisteDTO assiste : assistesDeLUtilisateur) {
				assistesDuCompte.add(assiste);
			}
		}
		return assistesDuCompte;
	}



}
