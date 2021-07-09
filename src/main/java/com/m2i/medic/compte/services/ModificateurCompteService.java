package com.m2i.medic.compte.services;

import com.m2i.medic.compte.dtos.DesactivationCompteDTO;
import com.m2i.medic.compte.dtos.InscriptionDTO;
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
	public void creerCompte(InscriptionDTO nouveauCompte);

	/**
	 * Cette méthode permet de modifier un compte
	 * @param compteModifier
	 */
	public void modifierCompte(ModificationCompteDTO compteModifie);
	
	/**
	 * Cette méthode permet de désactiver un compte
	 * @param compteDesactive
	 */
	public void desactiverCompte(DesactivationCompteDTO compteDesactive);
}
