package com.m2i.medic.services;

import com.m2i.medic.dtos.AuthentificationDTO;

public interface AuthentificationService {
	
	/**
	 * Cette méthode permet de retourner l'id d'un compte
	 * @param compte
	 */
	public String connexion(AuthentificationDTO compte);

}
