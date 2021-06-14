package com.m2i.medic.services.implementations;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.m2i.medic.dtos.AuthentificationDTO;
import com.m2i.medic.models.Compte;
import com.m2i.medic.repositories.CompteRepository;
import com.m2i.medic.services.AuthentificationService;

public class AuthentificationServiceImpl implements AuthentificationService {

	private CompteRepository repository;
	
	public AuthentificationServiceImpl(CompteRepository repository) {
		this.repository = repository;
	}
	
	
	@Override
	public String connexion(AuthentificationDTO authentificationDTO) {
		String email = authentificationDTO.getEmail();
		Compte compte = this.repository.findByEmail(email);

		if(compte == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		if (compte.getMotDePasse().equals(Base64.encode(authentificationDTO.getMotDePasse().getBytes())))
			return compte.getId();
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}

}
