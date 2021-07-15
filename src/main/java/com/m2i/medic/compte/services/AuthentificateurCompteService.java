package com.m2i.medic.compte.services;

import com.m2i.medic.compte.dtos.ConnexionCompteDTO;
import com.m2i.medic.compte.dtos.DesactivationCompteDTO;

/**
 * Cette interface représente un service authentificateur d'un compte
 * @author fabien
 *
 */
public interface AuthentificateurCompteService {

	/**
	 * Cette méthode permet de recupérer l'identifiant d'un compte
	 * @param connexion
	 * @return l'identifiant et l'état d'un compte
	 */
	public DesactivationCompteDTO seConnecterCompte(ConnexionCompteDTO connexion);
}
