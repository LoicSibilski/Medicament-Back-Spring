package com.m2i.medic.services.implementations;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.dtos.InscriptionDTO;
import com.m2i.medic.models.Compte;
import com.m2i.medic.repositories.CompteRepository;
import com.m2i.medic.services.ModificateurCompteService;

public class ModificateurCompteServiceImpl implements ModificateurCompteService {

	private ObjectMapper mapper;
	
	private CompteRepository repository;
		
	public ModificateurCompteServiceImpl(CompteRepository repository, ObjectMapper mapper) {
		this.mapper = mapper;
		this.repository = repository;
	}
	
	@Override
	public CompteDTO creerNouveauCompte(InscriptionDTO nouveauCompte) {
		String email = nouveauCompte.getEmail();
		String motDePasse = nouveauCompte.getMotDePasse();
		verifierCompteExiste(email);
		verifierAttributsCompte(email, motDePasse);
		Compte compte = this.mapper.convertValue(nouveauCompte, Compte.class);
		compte.setMotDePasse(Base64.encode(motDePasse.getBytes())); // modifier le chiffrement
		compte.setDateCreation(LocalDateTime.now());
		compte.setDateMisJour(LocalDateTime.now());
		Compte compteSauvegarde = this.repository.save(compte);
		return this.mapper.convertValue(compteSauvegarde, CompteDTO.class);
	}
	
	@Override
	public void modifierEmailMotDePasse(CompteDTO compte) {		
		String email = compte.getEmail();
		String motDePasse = compte.getMotDePasse();
		verifierCompteExiste(email);
		verifierAttributsCompte(email, motDePasse);
		Compte compteModifie = this.mapper.convertValue(compte, Compte.class);
		compteModifie.setMotDePasse(Base64.encode(motDePasse.getBytes()));
		compteModifie.setDateMisJour(LocalDateTime.now());
		this.repository.save(compteModifie);
	}

	@Override
	public void supprimerUnCompte(String id) {
		if(this.repository.existsById(id))
			this.repository.deleteById(id);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le compte n'existe pas");
	}

	@Override
	public void supprimerTousLesComptes() {
		this.repository.deleteAll();
	}
	
	/**
	 * Cette méthode permet de vérifier si le compte est conforme
	 * @param un compte
	 */
	private void verifierAttributsCompte(String email, String motDePasse) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^(.+)@(\\S+)$");
		Pattern VALID_MOTDEPASSE_ADDRESS_REGEX = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
		verifierAttributFormat(email, VALID_EMAIL_ADDRESS_REGEX);
		verifierAttributFormat(motDePasse, VALID_MOTDEPASSE_ADDRESS_REGEX);
	}
	
	/**
	 * Cette méthode permet de vérifier si un compte existe à partir d'une adresse email
	 * @param un compte
	 */
	private void verifierCompteExiste(String email) {
		InscriptionDTO compteRecupere = this.repository.findByEmail(email);
		if(compteRecupere != null) {			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'email existe déjà");
		}
	}
	
	
	/**
	 * Cette méthode permet de vérifier si l'attribut correspond au bon format (regex)
	 * @param un compte
	 */
	private void verifierAttributFormat(String attribut, Pattern pattern) {
        boolean attributValide = pattern.matcher(attribut).find();
        if(!attributValide) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'attribut ne respecte pas le bon format");
        }
	}
	
}
