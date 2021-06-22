package com.m2i.medic.services;

import java.util.List;

import com.m2i.medic.dtos.CompteDTO;

/**
 * Cette classe représente un service de compte
 * @author fabien
 *
 */
public interface CompteService {

	
	/**
	 * Cette méthode permet de récupérer tous les comptes
	 * @return une liste de comptes
	 */
	public List<CompteDTO> recupererTousLesComptes();
	
	/**
	 * Cette méthode permet de récupére un compte à partir d'un id
	 * @param l'id d'un compte
	 * @return un compte
	 */
	public CompteDTO recupererUnCompte(String id);	
	
	/**
	 * Cette méthode permet de supprimer tous les comptes
	 */
	public void supprimerTousLesComptes();
}
