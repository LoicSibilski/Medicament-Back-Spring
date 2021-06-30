package com.m2i.medic.compte.services.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.compte.dtos.DesactivationCompteDTO;
import com.m2i.medic.compte.dtos.InscriptionDTO;
import com.m2i.medic.compte.dtos.ModificationCompteDTO;
import com.m2i.medic.compte.repositories.ModificateurCompteRepository;
import com.m2i.medic.compte.services.ModificateurCompteService;

/**
 * Cette classe représente l'implémentation du service de modification d'un compte
 * @author fabien
 *
 */
public class ModificationCompteServiceImplementation implements ModificateurCompteService {

	private ObjectMapper mapper;

	private ModificateurCompteRepository repository;

	/**
	 * Constructeur
	 * @param mapper
	 * @param repository
	 */
	public ModificationCompteServiceImplementation(ObjectMapper mapper, ModificateurCompteRepository repository) {
		super();
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public void creerCompte(InscriptionDTO nouveauCompte) {
		
	}

	@Override
	public void modifierCompte(ModificationCompteDTO compteModifie) {
		
	}

	@Override
	public void desactiverCompte(DesactivationCompteDTO compteDesactive) {
		
	}
	
	/**
	 * Cette méthode permet de supprimer un compte
	 */
	private void supprimerCompte() {
		
	}
}
