package com.m2i.medic.services;

import java.util.List;

import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.dtos.InscriptionDTO;

/**
 * Cette classe représente un service de compte
 * @author fabien
 *
 */
public interface CompteService {

	/**
	 * Cette méthode permet de créer un nouveau compte à partir d'un compte
	 * @param un nouveau compte
	 * @return un compte 
	 */
	public CompteDTO creationNouveauCompte(InscriptionDTO nouveauCompte);
	
	/**
	 * Cette méthode permet de récupérer tous les comptes
	 * @return une liste de comptes
	 */
	public List<CompteDTO> recupererTousLesComptes();
	
	/**
	 * Cette méthode permet de récupére un compte à partir d'un identifiant
	 * @param l'identifiant d'un compte
	 * @return un compte
	 */
	public CompteDTO recupererUnCompte(String identifiant);

	/**
	 * Cette méthode permet de supprimer un compte à partir d'un identifiant
	 * @param l'identifiant d'un compte
	 */
	public void supprimerUnCompte(String identifiant);
	
	/**
	 * Cette méthode permet de supprimer tous les comptes
	 */
	public void supprimerTousLesComptes();
	
	
}
