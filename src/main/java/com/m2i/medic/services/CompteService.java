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
	 * Cette méthode permet de créer un nouveau compte à partir d'un DTO
	 * @param dto
	 * @return CompteDTO
	 */
	public CompteDTO creationNouveauCompteParDTO(CreationNouveauCompteDTO dto);
	
	/**
	 * Cette méthode permet de récupérer tous les comptes
	 * @return List<CompteDTO>
	 */
	public List<SimpleCompteDTO> recupererTousLesComptes();
	
	/**
	 * Cette méthode permet de récupére un compte à partir d'un id
	 * @param id
	 * @return SimpleCompteDTO
	 */
	public SimpleCompteDTO recupererUnCompteParId(String id);

	/**
	 * Cette méthode permet de supprimer un compte à partir d'un id
	 * @param id
	 */
	public void supprimerUnCompteParId(String id);
	
	
}
