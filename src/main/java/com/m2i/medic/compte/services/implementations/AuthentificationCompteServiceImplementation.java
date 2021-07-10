package com.m2i.medic.compte.services.implementations;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.compte.dtos.ConnexionDTO;
import com.m2i.medic.compte.dtos.DesactivationCompteDTO;
import com.m2i.medic.compte.dtos.InscriptionDTO;
import com.m2i.medic.compte.entities.Compte;
import com.m2i.medic.compte.repositories.AuthentificateurCompteRepository;
import com.m2i.medic.compte.services.AuthentificateurCompteService;

/**
 * Cette classe représente l'implémentation du service d'authentification d'un compte
 * @author fabien
 *
 */
public class AuthentificationCompteServiceImplementation implements AuthentificateurCompteService {

	private ObjectMapper mapper;

	private AuthentificateurCompteRepository repository;
	
	/**
	 * Constructeur
	 * @param mapper
	 * @param repository
	 */
	public AuthentificationCompteServiceImplementation(ObjectMapper mapper, AuthentificateurCompteRepository repository) {
		super();
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public DesactivationCompteDTO seConnecterCompte(ConnexionDTO compteConnexion) {
		Optional<Compte> optional = this.repository.findFirstByPseudoOrEmail(
				compteConnexion.getPseudoOrEmail(), compteConnexion.getPseudoOrEmail());
		
		Compte compte = optional.orElseThrow(()->{ 
			return new ResponseStatusException(HttpStatus.NOT_FOUND);
		});
		
		if (compte.getMotDePasse().equals(compteConnexion.getMotDePasse()) && compte.isEtat()) {
			DesactivationCompteDTO dto = this.mapper.convertValue(compte, DesactivationCompteDTO.class);
			return dto;
		}
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
}
