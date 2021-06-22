package com.m2i.medic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.dtos.InscriptionDTO;
import com.m2i.medic.services.CompteService;
import com.m2i.medic.services.ModificateurCompteService;


/**
 * Cette classe représente un controller de compte
 * @author fabien
 *
 */
@RestController
@RequestMapping("comptes")
public class CompteController {

	@Autowired
	private CompteService compteService;
	
	@Autowired
	private ModificateurCompteService modificateurCompteService;
	
	/**
	 * Cette méthode permet de retourner un service pour créer un nouveau compte
	 * @param un nouveau compte
	 * @return un service pour créer un compte
	 */
	@PostMapping("")
	public CompteDTO creationNouveauCompte(@RequestBody InscriptionDTO nouveauCompte) {
		return this.modificateurCompteService.creerNouveauCompte(nouveauCompte);
	}
	
	/**
	 * Cette méthode permet de retourner un service pour récupérer tous les comptes
	 * @return un service pour récupérer une liste de comptes
	 */
	@GetMapping("")
	public List<CompteDTO> recupererTousLesComptes(){
		return this.compteService.recupererTousLesComptes();
	}
	
	/**
	 * Cette méthode permet de retourner un service pour récupérer un compte
	 * @param l'id d'un compte
	 * @return un service pour récupérer un compte
	 */
	@GetMapping("{id}")
	public CompteDTO recupererUnCompte(@PathVariable String id) {
		return this.compteService.recupererUnCompte(id);
	}
	
	/**
	 * Cette méthode permet de retourne un service pour modifier un compte
	 * @param un compte
	 */
	@PatchMapping("")
	public void modifierCompte(@RequestBody CompteDTO compte) {
		this.modificateurCompteService.modifierCompte(compte);
	}
	
	
	/**
	 * Cette méthode permet de supprimer tous les comptes
	 */
	@DeleteMapping("")
	public void supprimerTousLesComptes() {
		this.modificateurCompteService.supprimerTousLesComptes();
	}
	
	/**
	 * Cette méthode permet de supprimer un compte à partir d'un id
	 * @param id
	 */
	@DeleteMapping("{id}")
	public void supprimerUncompte(@PathVariable String id) {
		this.modificateurCompteService.supprimerUnCompte(id);
	}
	
	/**
	 * Cette méthode permet de supprimer un compte
	 * @param l'identifiant d'un compte
	 */
	@DeleteMapping("{id}")
	public void supprimerUnCompte(@PathVariable String id) {
		this.service.supprimerUnCompte(id);
	}
	
	/**
	 * Cette méthode permet de supprimer tous les comptes
	 */
	@DeleteMapping()
	public void supprimerTousLesComptes() {
		this.service.supprimerTousLesComptes();
	}
	
	
}
