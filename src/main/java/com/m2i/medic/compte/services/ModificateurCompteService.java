package com.m2i.medic.compte.services;

import com.m2i.medic.compte.dtos.DesactivationCompteDTO;
import com.m2i.medic.compte.dtos.InscriptionCompteDTO;
import com.m2i.medic.compte.dtos.ModificationCompteDTO;

/**
 * Cette interface représente un service modificateur d'un compte
 * @author fabien
 *
 */
public interface ModificateurCompteService {
	
	/**
	 * Cette méthode permet de créer un compte
	 * @param nouveauCompte
	 */
	public boolean creerCompte(InscriptionCompteDTO nouveauCompte);

	/**
	 * Cette méthode permet de modifier un compte
	 * @param compteModifier
	 */
	public boolean modifierCompte(ModificationCompteDTO compteModifie);
	
	/**
	 * Cette méthode permet de désactiver un compte
	 * @param compteDesactive
	 */
	public void desactiverCompte(DesactivationCompteDTO compteDesactive);
}
