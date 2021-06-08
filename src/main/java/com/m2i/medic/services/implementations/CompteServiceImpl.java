package com.m2i.medic.services.implementations;

import java.time.LocalDateTime;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.dtos.CreationNouveauCompteDTO;
import com.m2i.medic.models.Compte;
import com.m2i.medic.repositories.CompteRepository;
import com.m2i.medic.services.CompteService;

/**
 * Cette classe représente l'implémentation du service d'un compte
 * @author fabien
 *
 */
public class CompteServiceImpl implements CompteService {
	
	private ObjectMapper mapper;
	
	private CompteRepository repository;
	
	/**
	 * Constructeur
	 * @param repository
	 * @param mapperParam
	 */
	public CompteServiceImpl(CompteRepository repository, ObjectMapper mapperParam) {
		this.repository = repository;
		this.mapper = mapperParam;
	}

	@Override
	public CompteDTO creationNouveauCompte(CreationNouveauCompteDTO dto) {
		// verifier que l'email, le mot de passe et le mot de passe ont une valeur
		verifierCreationCompte(dto);
		// verifier que les mots de passe sont identiques
		verifierMotDePasses(dto.getMotDePasse(), dto.getMotDePasseConfirme());
		Compte compte = this.mapper.convertValue(dto, Compte.class);
		compte.setMotDePasse(Base64.encode(dto.getMotDePasse().getBytes())); // modifier le chiffrement (actuellement ce n'est pas sécurisé)
		compte.setDateCreation(LocalDateTime.now());
		compte.setDateMisJour(LocalDateTime.now());
		Compte result = this.repository.save(compte);
		return this.mapper.convertValue(result, CompteDTO.class);
	}
	
	/**
	 * Cette méthode permet de vérifier si les attributs (email, mot de passe, mot de passe confirmé) d'un compte sont remplis
	 * @param dto
	 */
	private void verifierCreationCompte(CreationNouveauCompteDTO dto) {
		if(dto.getEmail() == null || dto.getMotDePasse() == null || dto.getMotDePasseConfirme() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST); // Afficher un message de l'attribut null
		}
	}
	
	/**
	 * Cette méthode permet de vérifier que les deux mots de passe sont identiques
	 * @param motDePasse
	 * @param motDePasseConfirme
	 */
	private void verifierMotDePasses(String motDePasse, String motDePasseConfirme) {
		System.out.println(motDePasse + " " + motDePasseConfirme);
		if(motDePasse != motDePasseConfirme) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Les mots de passe sont incorrectes");
		}
	}
	
}
