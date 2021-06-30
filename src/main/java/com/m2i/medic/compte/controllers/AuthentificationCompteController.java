package com.m2i.medic.compte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.medic.compte.dtos.ConnexionDTO;
import com.m2i.medic.compte.services.AuthentificateurCompteService;

/**
 * Cette classe représente un contrôleur d'autentification d'un compte
 * @author fabien
 *
 */
@RestController
@RequestMapping("auth")
@CrossOrigin
public class AuthentificationCompteController {

	@Autowired
	private AuthentificateurCompteService authService;
	
	public String seConnecterCompte(ConnexionDTO connexion) {
		return this.authService.seConnecterCompte(connexion);
	}
}
