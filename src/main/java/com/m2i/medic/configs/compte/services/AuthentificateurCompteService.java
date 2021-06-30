package com.m2i.medic.configs.compte.services;

import com.m2i.medic.configs.compte.dtos.ConnexionDTO;

/**
 * Cette classe représente un service d'authentication d'un compte
 * @author fabien
 *
 */
public interface AuthentificateurCompteService {

	/**
	 * Cette méthode permet de recupérer se connecter à un compte
	 * @param connexion
	 * @return l'identificant d'un compte
	 */
	public String seConnecterCompte(ConnexionDTO connexion);
}
