package com.m2i.medic.services.implementations;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.AuthentificationDTO;
import com.m2i.medic.dtos.InscriptionDTO;
import com.m2i.medic.models.Compte;
import com.m2i.medic.repositories.CompteRepository;
import com.m2i.medic.services.AuthentificationService;

public class AuthentificationServiceImpl implements AuthentificationService {
	
	private ObjectMapper mapper;

	private CompteRepository repository;
	
	public AuthentificationServiceImpl(CompteRepository repository, ObjectMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	
	@Override
	public String connexion(AuthentificationDTO authentificationDTO) {
		String email = authentificationDTO.getEmail();
		InscriptionDTO dto = this.repository.findByEmail(email); // modifier InscriptionDTO
		Compte compte = this.mapper.convertValue(dto, Compte.class);

		if(compte == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		if (compte.getMotDePasse().equals(Base64.encode(authentificationDTO.getMotDePasse().getBytes())))
			return compte.getId();
		throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}

}
