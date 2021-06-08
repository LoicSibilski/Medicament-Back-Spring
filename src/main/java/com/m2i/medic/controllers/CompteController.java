package com.m2i.medic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.dtos.CreationNouveauCompteDTO;
import com.m2i.medic.dtos.SimpleCompteDTO;
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
	public CompteDTO creationNouveauCompte(@RequestBody CreationNouveauCompteDTO dto) {
		return this.service.creationNouveauCompte(dto);
	}
	
	/**
	 * Cette méthode permet de retourner un service pour récupérer tous les comptes
	 * @return List<SimpleCompteDTO>
	 */
	@GetMapping("")
	public List<SimpleCompteDTO> recupérerTousLesComptes(){
		return this.service.recupererTousLesComptes();
	}
}
