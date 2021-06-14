package com.m2i.medic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.dtos.InscriptionDTO;
import com.m2i.medic.services.CompteService;

/**
 * Cette classe représente un controller de compte
 * @author fabien
 *
 */
@RestController
@RequestMapping("comptes")
public class CompteController {

	@Autowired
	private CompteService service;
	
	/**
	 * Cette méthode permet de retourner un service pour créer un nouveau compte
	 * @param dto
	 * @return CompteDTO
	 */
	@PostMapping("")
	public CompteDTO creationNouveauCompte(@RequestBody InscriptionDTO nouveauCompte) {
		return this.service.creationNouveauCompte(nouveauCompte);
	}
	
	/**
	 * Cette méthode permet de retourner un service pour récupérer tous les comptes
	 * @return un service pour récupérer une liste de comptes
	 */
	@GetMapping("")
	public List<CompteDTO> recupererTousLesComptes(){
		return this.service.recupererTousLesComptes();
	}
	
	/**
	 * Cette méthode permet de retourner un service pour récupérer un compte
	 * @param l'id d'un compte
	 * @return un service pour récupérer un compte
	 */
	@GetMapping("{id}")
	public CompteDTO recupererUnCompte(@PathVariable String id) {
		return this.service.recupererUnCompte(id);
	}
	
	/**
	 * Cette méthode permet de supprimer tous les comptes
	 */
	@DeleteMapping("")
	public void supprimerTousLesComptes() {
		this.service.supprimerTousLesComptes();
	}
	
	/**
	 * Cette méthode permet de supprimer un compte à partir d'un id
	 * @param id
	 */
	@DeleteMapping("{id}")
	public void supprimerUncompte(@PathVariable String id) {
		this.service.supprimerUnCompte(id);
	}
}
