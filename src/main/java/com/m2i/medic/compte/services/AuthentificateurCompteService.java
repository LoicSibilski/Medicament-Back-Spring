package com.m2i.medic.compte.services;

import com.m2i.medic.compte.dtos.ConnexionDTO;

/**
 * Cette interface représente un service authentificateur d'un compte
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
