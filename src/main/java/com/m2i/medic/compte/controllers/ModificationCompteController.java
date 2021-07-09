package com.m2i.medic.compte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.medic.compte.dtos.DesactivationCompteDTO;
import com.m2i.medic.compte.dtos.InscriptionDTO;
import com.m2i.medic.compte.dtos.ModificationCompteDTO;
import com.m2i.medic.compte.services.ModificateurCompteService;

/**
 * Cette classe représente un contrôleur de modification d'un compte
 * @author fabien
 *
 */
@RestController
@RequestMapping("comptes")
@CrossOrigin
public class ModificationCompteController {

	@Autowired
	private ModificateurCompteService service;
	
	/**
	 * Cette méthode permet de creer un compte à partir du service
	 * @param nouveauCompte
	 */
	@PostMapping("")
	public void creerCompte(@RequestBody InscriptionDTO nouveauCompte) {
		this.service.creerCompte(nouveauCompte);
	}
	
	/**
	 * Cette méthode permet de modifier un compte à partir du service
	 * @param compteModifie
	 */
	@PatchMapping("")
	public void modifierCompte(@RequestBody ModificationCompteDTO compteModifie) {
		this.service.modifierCompte(compteModifie);
	}
	
	/**
	 * Cette méthode permet de desactiver un compte à partir du service
	 * @param compteDesactive
	 */
	@PatchMapping("/desactiver")
	public void desactiverCompte(@RequestBody DesactivationCompteDTO compteDesactive) {
		this.service.desactiverCompte(compteDesactive);
	}
	
}
