package com.m2i.medic.services.duree;

import com.m2i.medic.dtos.duree.CreationDureeDto;
import com.m2i.medic.dtos.duree.DureeDto;

public interface CreationDureeDtoService {

	/**
	 * La methode permet de creer un DureeDto à partir du CréationDureeDto fournis
	 * par le FRONT
	 * 
	 * @param CreationDureeDto : DTO contenant les informations fournis par
	 *                         l'utilisateur depuis le FRONT
	 * 
	 * @return DureeDto : DTO contenant les informations après le traitement par le
	 *         BACK
	 */
	public DureeDto convertCreationDureeDtoToDureeDto(CreationDureeDto creationDureeDto);
	
}
