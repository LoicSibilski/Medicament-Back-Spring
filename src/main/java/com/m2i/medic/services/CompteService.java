package com.m2i.medic.services;

import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.dtos.CreationNouveauCompteDTO;

/**
 * Cette classe représente un service de compte
 * @author fabien
 *
 */
public interface CompteService {

	/**
	 * Cette méthode permet de créer un nouveau compte
	 * @param dto
	 * @return CompteDTO
	 */
	public CompteDTO creationNouveauCompte(CreationNouveauCompteDTO dto);
	
}
