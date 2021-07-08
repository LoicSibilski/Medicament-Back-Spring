package com.m2i.medic.compte.services.implementations;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.compte.dtos.DesactivationCompteDTO;
import com.m2i.medic.compte.dtos.InscriptionDTO;
import com.m2i.medic.compte.dtos.ModificationCompteDTO;
import com.m2i.medic.compte.entities.Compte;
import com.m2i.medic.compte.repositories.ModificateurCompteRepository;
import com.m2i.medic.compte.services.ModificateurCompteService;

/**
 * Cette classe représente l'implémentation du service de modification d'un
 * compte
 * 
 * @author fabien
 *
 */
public class ModificationCompteServiceImplementation implements ModificateurCompteService {

	private ObjectMapper mapper;

	private ModificateurCompteRepository repository;
	
	private VerificationCompteServiceImplementation verificateur;
		
	/**
	 * Constructeur
	 * 
	 * @param mapper
	 * @param repository
	 */
	public ModificationCompteServiceImplementation(ObjectMapper mapper, ModificateurCompteRepository repository, VerificationCompteServiceImplementation verificateur) {
		this.mapper = mapper;
		this.repository = repository;
		this.verificateur = verificateur;
	}

	@Override
	public void creerCompte(InscriptionDTO nouveauCompte) {
		this.verificateur.verifierDonneesCompte(nouveauCompte);
		Compte compte = this.mapper.convertValue(nouveauCompte, Compte.class);
		compte.setMotDePasse(new BCryptPasswordEncoder().encode(nouveauCompte.getMotDePasse()));
		compte.setDateCreation(LocalDateTime.now());
		compte.setEtat(true);
		this.repository.save(compte);
	}

	@Override
	public void modifierCompte(ModificationCompteDTO compteModifie) {
		this.verificateur.verifierDonneesCompte(compteModifie);
		Compte nouveauCompte = this.mapper.convertValue(compteModifie, Compte.class);
		nouveauCompte.setEmail(compteModifie.getEmail());
		nouveauCompte.setPseudo(compteModifie.getPseudo());
		nouveauCompte.setMotDePasse(new BCryptPasswordEncoder().encode(compteModifie.getMotDePasse()));
		nouveauCompte.setDateMisJour(LocalDateTime.now());
		nouveauCompte.setEtat(true);
		this.repository.save(nouveauCompte);
	}	

	@Override
	public void desactiverCompte(DesactivationCompteDTO compteDesactive) {
		this.verificateur.verifierDonneesCompte(compteDesactive);
		Optional<Compte> compte = this.repository.findById(compteDesactive.getId());
		Compte compteSuspendu = this.mapper.convertValue(compte, Compte.class);
		compteSuspendu.setEmail(compte.get().getEmail());
		compteSuspendu.setPseudo(compte.get().getPseudo());
		compteSuspendu.setMotDePasse(new BCryptPasswordEncoder().encode(compte.get().getMotDePasse()));
		compteSuspendu.setDateMisJour(LocalDateTime.now());
		compteSuspendu.setEtat(false);
		this.repository.save(compteSuspendu);
	}

	/**
	 * Cette méthode permet de supprimer un compte
	 */
	private void supprimerCompte(String id) {
		this.repository.deleteById(id);
	}
}
