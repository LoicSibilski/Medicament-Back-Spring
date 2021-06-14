package com.m2i.medic.services;

import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.dtos.InscriptionDTO;

/**
 * Cette classe represente un sevice pour modifier un compte
 * @author fabien
 *
 */
public interface ModificateurCompteService {

	/**
	 * Cette méthode permet de créer un nouveau compte à partir d'un compte
	 * @param un nouveau compte
	 * @return un compte 
	 */
	public CompteDTO creerNouveauCompte(InscriptionDTO nouveauCompte);
	
	/**
	 * Cette méthode permet de modifier l'email d'un compte
	 * @param une adresse email
	 */
	public void modifierCompte(CompteDTO compte);
	
	/**
	 * Cette méthode permet de supprimer un compte à partir d'un id
	 * @param l'id d'un compte
	 */
	public void supprimerUnCompte(String id);
	
	/**
	 * Cette méthode permet de supprimer tous les comptes
	 */
	public void supprimerTousLesComptes();
}
