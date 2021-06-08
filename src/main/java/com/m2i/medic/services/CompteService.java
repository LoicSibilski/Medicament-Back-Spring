package com.m2i.medic.services;

import java.util.List;

import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.dtos.CreationNouveauCompteDTO;
import com.m2i.medic.dtos.SimpleCompteDTO;

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
	
	/**
	 * Cette méthode permet de récupérer tous les comptes
	 * @return List<CompteDTO>
	 */
	public List<SimpleCompteDTO> recupererTousLesComptes();
	
	/**
	 * Cette méthode permet de récupére un compte
	 * @param id
	 * @return SimpleCompteDTO
	 */
	public SimpleCompteDTO recupererCompte(String id);


}
