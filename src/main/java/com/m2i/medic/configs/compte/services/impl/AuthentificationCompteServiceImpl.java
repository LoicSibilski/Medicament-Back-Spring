package com.m2i.medic.configs.compte.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.configs.compte.dtos.ConnexionDTO;
import com.m2i.medic.configs.compte.repositories.AuthentificateurCompteRepository;
import com.m2i.medic.configs.compte.services.AuthentificateurCompteService;

/**
 * Cette classe représente l'implémentation du service d'authentification d'un compte
 * @author fabien
 *
 */
public class AuthentificationCompteServiceImpl implements AuthentificateurCompteService {

	private ObjectMapper mapper;

	private AuthentificateurCompteRepository repository;

	@Override
	public String seConnecterCompte(ConnexionDTO connexion) {
		return null;
	}
}
