package com.m2i.medic.compte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.medic.compte.dtos.ConnexionDTO;
import com.m2i.medic.compte.services.AuthentificateurCompteService;

/**
 * Cette classe représente un contrôleur d'authentification d'un compte
 * @author fabien
 *
 */
@RestController
@RequestMapping("auth")
@CrossOrigin
public class AuthentificationCompteController {

	@Autowired
	private AuthentificateurCompteService service;
	
	/**
	 * Cette méthode permet de se connecter à un compte à partir du service
	 * @param connexion
	 * @return l'identifiant du compte
	 */
	@PostMapping("connexion")
	public String seConnecterCompte(ConnexionDTO connexion) {
		return this.service.seConnecterCompte(connexion);
	}
}
