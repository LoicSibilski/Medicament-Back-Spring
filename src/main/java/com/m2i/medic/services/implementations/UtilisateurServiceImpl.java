package com.m2i.medic.services.implementations;

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
		return this.repository.findAllAssistantsByCompteId(id);
	}

	@Override
	public List<AssistantOuAssisteDTO> findAllByAssistantOuAssiteDTOId(String id) {
		return this.repository.findAllByAssistantOuAssisteDTOId(id);
	}

}
