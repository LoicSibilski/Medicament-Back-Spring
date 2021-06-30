package com.m2i.medic.compte.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.compte.dtos.ConnexionDTO;
import com.m2i.medic.compte.repositories.AuthentificateurCompteRepository;
import com.m2i.medic.compte.services.AuthentificateurCompteService;

/**
 * Cette classe représente l'implémentation du service d'authentification d'un compte
 * @author fabien
 *
 */
public class AuthentificationCompteServiceImpl implements AuthentificateurCompteService {

	private ObjectMapper mapper;

	private AuthentificateurCompteRepository repository;
	
	/**
	 * Constructeur
	 * @param mapper
	 * @param repository
	 */
	public AuthentificationCompteServiceImpl(ObjectMapper mapper, AuthentificateurCompteRepository repository) {
		super();
		this.mapper = mapper;
		this.repository = repository;
	}



	@Override
	public String seConnecterCompte(ConnexionDTO connexion) {
		return null;
	}
}
