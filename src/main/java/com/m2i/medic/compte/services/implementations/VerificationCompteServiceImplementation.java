package com.m2i.medic.compte.services.implementations;

import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.compte.dtos.DesactivationCompteDTO;
import com.m2i.medic.compte.dtos.InscriptionCompteDTO;
import com.m2i.medic.compte.dtos.ModificationCompteDTO;
import com.m2i.medic.compte.repositories.ModificateurCompteRepository;
import com.m2i.medic.compte.services.VerificateurCompteService;

public class VerificationCompteServiceImplementation implements VerificateurCompteService{
	
	private ModificateurCompteRepository repository;
	
	private ObjectMapper mapper;
	
	public VerificationCompteServiceImplementation(ModificateurCompteRepository repository, ObjectMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	/**
	 * Cette méthode permet de verifier les données d'un DTO d'un compte
	 * @param nouveauCompte
	 */
	public void verifierDonneesCompte(InscriptionCompteDTO nouveauCompte) {
		boolean emailExiste = verifierEmailExiste(nouveauCompte.getEmail());
		boolean emailFormatValide = verifierEmailFormatValide(nouveauCompte.getEmail());
		boolean motDePasseFormatValide = verifierMotDePasseFormatValide(nouveauCompte.getMotDePasse());
		
		if (!emailFormatValide || !motDePasseFormatValide || emailExiste)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Cette méthode permet de vérifier les données d'un dto quand le compte est modifié
	 * @param compteModifie
	 */
	public void verifierDonneesCompte(ModificationCompteDTO compteModifie) {
		DesactivationCompteDTO compteAVerifierId =  this.mapper.convertValue(compteModifie, DesactivationCompteDTO.class);
		verifierDonneesCompte(compteAVerifierId);
		InscriptionCompteDTO compteAVerifier =  this.mapper.convertValue(compteModifie, InscriptionCompteDTO.class);
		verifierDonneesCompte(compteAVerifier);
	}
	
	/**
	 * Cette méthode permet de vérifier les données d'un dto quand le compte est désactivé
	 * @param compteDesactive
	 */
	public void verifierDonneesCompte(DesactivationCompteDTO compteDesactive) {
		boolean idExiste = verifierIdExiste(compteDesactive.getId());
		if(!idExiste)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}

	@Override
	public boolean verifierIdExiste(String id) {
		return this.repository.findById(id) == null ? false : true;
	}

	@Override
	public boolean verifierEmailExiste(String email) {
		return this.repository.findByEmail(email) == null ? false : true;
	}

	@Override
	public boolean verifierEmailFormatValide(String email) {
		Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\""
				+ "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])"
				+ "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]"
				+ "|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]"
				+ ":(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
		return pattern.matcher(email).matches();
	}

	@Override
	public boolean verifierMotDePasseFormatValide(String motDePasse) {
		Pattern pattern = Pattern
				.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
		return pattern.matcher(motDePasse).matches();
	}
}
