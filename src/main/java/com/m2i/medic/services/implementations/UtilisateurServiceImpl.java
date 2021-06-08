package com.m2i.medic.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
	public void save(Utilisateur[] entity) {
		for (Utilisateur utilisateur : entity) {
			this.repository.save(utilisateur);
		}
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

}
